package com.kiraged.script.variable;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class StaticVariable extends Variable {

    private final String name;

    private final ExpressionNode expression;

    public StaticVariable(Type type, String name, ExpressionNode expression) {
        super(type);
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope, boolean callExpression) {
        if (expression != null && callExpression) {
            expression.toBytecode(bytecode, scope);
        }
        bytecode.add("putstatic " + scope.getClassName() + "/" + name + " " + getType().getDescriptor());
    }

    @Override
    public void toByteCodeCall(JasminBytecode bytecode, Scope scope) {
        bytecode.add("getstatic " + scope.getClassName() + "/" + name + " " + getType().getDescriptor());
    }

    @Override
    public void toByteCodeInitialize(JasminBytecode bytecode, Scope scope) {
        bytecode.add(".field public static " + name + " " + getType().getDescriptor());
    }

    @Override
    public String toString() {
        return "StaticVariable{" +
                ", name='" + name + '\'' +
                ", expression=" + expression +
                "} ";
    }

    public String getName() {
        return name;
    }

    public ExpressionNode getExpression() {
        return expression;
    }
}
