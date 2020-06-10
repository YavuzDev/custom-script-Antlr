package com.kiraged.script.ast.expression;

import com.kiraged.script.Type;
import com.kiraged.script.exception.NonMatchingType;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public abstract class InfixExpressionNode extends ExpressionNode {

    protected final ExpressionNode left;

    protected final ExpressionNode right;

    public InfixExpressionNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        left.typeCheck(scope, returnType, returned);
        right.typeCheck(scope, returnType, returned);

        Type leftType = left.getType(scope);
        Type rightType = right.getType(scope);

        if (leftType != rightType) {
            throw new NonMatchingType("Type " + left + " and type " + right + " don't match");
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        left.toBytecode(bytecode, scope);
        right.toBytecode(bytecode, scope);
    }

    @Override
    public Type getType(Scope scope) {
        return left.getType(scope);
    }

    @Override
    public String toString() {
        return "InfixExpressionNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public ExpressionNode getRight() {
        return right;
    }
}
