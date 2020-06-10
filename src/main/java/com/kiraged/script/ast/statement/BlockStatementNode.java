package com.kiraged.script.ast.statement;

import com.kiraged.script.Type;
import com.kiraged.script.ast.ParameterDeclarationNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

import java.util.List;

public class BlockStatementNode extends StatementNode {

    private final List<StatementNode> statements;

    public BlockStatementNode(List<StatementNode> statements) {
        this.statements = statements;
    }

    private Scope newScope;

    private List<ParameterDeclarationNode> parameters;

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        newScope = new Scope(scope.getClassName(), scope);

        if (parameters != null) {
            for (ParameterDeclarationNode parameter : parameters) {
                parameter.typeCheck(newScope, returnType, returned);
            }
        }

        boolean foundReturn = false;
        for (StatementNode statement : statements) {
            statement.typeCheck(newScope, returnType, foundReturn);
            if (statement instanceof ReturnStatementNode) {
                foundReturn = true;
            }
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        newScope = new Scope(scope.getClassName(), scope);

        if (parameters != null) {
            parameters.forEach(p -> p.toBytecode(bytecode, newScope));
        }

        statements.forEach(s -> s.toBytecode(bytecode, newScope));
    }

    @Override
    public String toString() {
        return "BlockStatementNode{" +
                "statements=" + statements +
                ", newScope=" + newScope +
                ", parameters=" + parameters +
                '}';
    }

    public List<StatementNode> getStatements() {
        return statements;
    }

    public Scope getNewScope() {
        return newScope;
    }

    public void setNewScope(Scope newScope) {
        this.newScope = newScope;
    }

    public List<ParameterDeclarationNode> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDeclarationNode> parameters) {
        this.parameters = parameters;
    }
}
