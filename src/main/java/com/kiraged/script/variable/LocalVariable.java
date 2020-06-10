package com.kiraged.script.variable;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class LocalVariable extends Variable {

    private final int id;

    private final ExpressionNode expression;

    public LocalVariable(Type type, int id, ExpressionNode expression) {
        super(type);
        this.id = id;
        this.expression = expression;
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope, boolean callExpression) {
        if (expression != null && callExpression) {
            expression.toBytecode(bytecode, scope);
        }
        bytecode.add(getType().getStore() + " " + id);
    }

    @Override
    public void toByteCodeCall(JasminBytecode bytecode, Scope scope) {
        bytecode.add(getType().getLoad() + " " + id);
    }

    @Override
    public String toString() {
        return "LocalVariable{" +
                ", id=" + id +
                ", expression=" + expression +
                "} ";
    }

    public int getId() {
        return id;
    }

    public ExpressionNode getExpression() {
        return expression;
    }
}
