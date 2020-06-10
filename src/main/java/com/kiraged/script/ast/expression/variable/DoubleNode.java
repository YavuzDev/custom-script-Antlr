package com.kiraged.script.ast.expression.variable;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.ParserException;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class DoubleNode extends ExpressionNode {

    private final String value;

    public DoubleNode(String value) {
        this.value = value;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        try {
            Double.parseDouble(value);
        } catch (Exception e) {
            throw new ParserException(value + " is too high to be a double");
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        bytecode.add("ldc2_w " + Double.parseDouble(value));
    }

    @Override
    public Type getType(Scope scope) {
        return Type.DOUBLE;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                '}';
    }

    public String getValue() {
        return value;
    }
}
