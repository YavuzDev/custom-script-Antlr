package com.kiraged.script.ast.expression.variable;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.ParserException;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class IntNode extends ExpressionNode {

    private final String value;

    public IntNode(String value) {
        this.value = value;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            throw new ParserException(value + " is too high to be an integer");
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        bytecode.add("ldc " + Integer.parseInt(value));
    }

    @Override
    public Type getType(Scope scope) {
        return Type.INT;
    }

    @Override
    public String toString() {
        return "IntNode{" +
                "value=" + value +
                "}";
    }

    public String getValue() {
        return value;
    }
}
