package com.kiraged.script.ast;

import com.kiraged.script.Type;
import com.kiraged.script.ast.statement.StatementNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.function.StaticJavaFunction;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;
import com.kiraged.script.variable.Variable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CompileUnitNode extends AstNode {

    private final List<StatementNode> statements;

    private final List<FunctionDeclarationNode> functions;

    public CompileUnitNode(List<StatementNode> statements, List<FunctionDeclarationNode> functions) {
        this.statements = statements;
        this.functions = functions;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        addFunctions(new JasminBytecode(scope.getClassName()), scope);

        for (StatementNode statement : statements) {
            statement.typeCheck(scope, returnType, returned);
        }

        for (FunctionDeclarationNode function : functions) {
            function.typeCheck(scope, returnType, returned);
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        JasminBytecode placeholder = new JasminBytecode(scope.getClassName());

        addFunctions(placeholder, scope);

        placeholder.add(".method public static main([Ljava/lang/String;)V");
        placeholder.add(".limit stack 100");
        placeholder.add(".limit locals 100");
        placeholder.add("");

        statements.forEach(s -> s.toBytecode(placeholder, scope));

        placeholder.add("  return");
        placeholder.add(".end method");

        functions.forEach(f -> f.toBytecode(placeholder, scope));

        Collection<Variable> staticVars = scope.getVariables().values();
        staticVars.forEach(v -> v.toByteCodeInitialize(bytecode, scope));
        bytecode.add(".method static public <clinit>()V");
        bytecode.add(".limit stack " + (staticVars.size() * 8));
        staticVars.forEach(v -> v.toBytecode(bytecode, scope, true));
        bytecode.add("return");
        bytecode.add(".end method");

        placeholder.getLines().forEach(bytecode::add);
    }

    @Override
    public String toString() {
        return "CompileUnitNode{" +
                "statements=" + statements +
                ", functions=" + functions +
                '}';
    }

    private void addFunctions(JasminBytecode placeholder, Scope scope) {
        functions.forEach(function -> {
            List<Type> parameters = function.getParameters()
                    .stream()
                    .map(ParameterDeclarationNode::getType)
                    .collect(Collectors.toList());

            String description = parameters
                    .stream().map(Type::getDescriptor)
                    .collect(Collectors.joining());

            scope.addFunction(
                    function.getName(),
                    parameters,
                    new StaticJavaFunction(placeholder.getClassName(), function.getName(), "(" + description + ")" + function.getType().getDescriptor(), function.getType())
            );
        });
    }

    public List<StatementNode> getStatements() {
        return statements;
    }

    public List<FunctionDeclarationNode> getFunctions() {
        return functions;
    }
}
