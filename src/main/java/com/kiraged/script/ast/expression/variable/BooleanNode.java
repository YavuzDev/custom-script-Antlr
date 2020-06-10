package com.kiraged.script.ast.expression.variable;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class BooleanNode extends ExpressionNode {

    private final boolean value;

    public BooleanNode(boolean value) {
        this.value = value;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {

    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        if (value) {
            bytecode.add("iconst_1");
        } else {
            bytecode.add("iconst_0");
        }
    }

    @Override
    public Type getType(Scope scope) {
        return Type.BOOLEAN;
    }

    @Override
    public String toString() {
        return "BooleanNode{" +
                "value=" + value +
                '}';
    }

    public boolean isValue() {
        return value;
    }
}
