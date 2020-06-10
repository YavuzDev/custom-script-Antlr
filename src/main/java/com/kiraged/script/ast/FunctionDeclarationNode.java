package com.kiraged.script.ast;

import com.kiraged.script.Type;
import com.kiraged.script.ast.statement.BlockStatementNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.exception.TypeNotFoundException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionDeclarationNode extends AstNode {

    private final Type type;

    private final String name;

    private final List<ParameterDeclarationNode> parameters;

    private final BlockStatementNode blockStatementNode;

    public FunctionDeclarationNode(Type type, String name, List<ParameterDeclarationNode> parameters,
                                   BlockStatementNode blockStatementNode) {
        this.type = type;
        this.name = name;
        this.parameters = parameters;
        this.blockStatementNode = blockStatementNode;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (type == null) {
            throw new TypeNotFoundException("No type found at " + name);
        }

        blockStatementNode.setParameters(parameters);
        blockStatementNode.typeCheck(scope, type, returned);
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        String description = parameters
                .stream()
                .map(t -> t.getType().getDescriptor())
                .collect(Collectors.joining());

        bytecode.add(".method public static " + name + "(" + description + ")" + type.getDescriptor());
        bytecode.add("");
        blockStatementNode.setParameters(parameters);
        blockStatementNode.toBytecode(bytecode, scope);
        if (type == Type.VOID) {
            bytecode.add(type.getReturnStatement());
        }

        int totalVariables = blockStatementNode.getNewScope().getTotalVariablesInScope() + parameters.size();
        int stackSize = totalVariables == 0 ? 8 : (totalVariables * 8);

        bytecode.add(".limit stack " + stackSize);
        bytecode.add(".limit locals " + (totalVariables + 10));
        bytecode.add(".end method");
    }

    @Override
    public String toString() {
        return "FunctionDeclarationNode{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", blockStatementNode=" + blockStatementNode +
                "} ";
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<ParameterDeclarationNode> getParameters() {
        return parameters;
    }

    public BlockStatementNode getBlockStatementNode() {
        return blockStatementNode;
    }
}
