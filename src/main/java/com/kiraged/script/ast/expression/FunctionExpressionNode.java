package com.kiraged.script.ast.expression;

import com.kiraged.script.Type;
import com.kiraged.script.exception.FunctionNotFoundException;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.function.Function;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionExpressionNode extends ExpressionNode {

    private final String name;

    private final List<ExpressionNode> arguments;

    public FunctionExpressionNode(String name, List<ExpressionNode> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    private Function getFunction(Scope scope) {
        List<Type> types = arguments.stream()
                .map(args -> args.getType(scope))
                .collect(Collectors.toList());
        return scope.getFunction(name, types);
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        for (ExpressionNode expression : arguments) {
            expression.typeCheck(scope, returnType, returned);
        }

        if (getFunction(scope) == null) {
            throw new FunctionNotFoundException("No function named " + name + " found with the args " + arguments);
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        getFunction(scope).toBytecode(bytecode, scope, arguments);
    }

    @Override
    public Type getType(Scope scope) {
        return getFunction(scope).getReturnType();
    }

    @Override
    public String toString() {
        return "FunctionExpressionNode{" +
                "name='" + name + '\'' +
                ", arguments=" + arguments +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<ExpressionNode> getArguments() {
        return arguments;
    }
}
