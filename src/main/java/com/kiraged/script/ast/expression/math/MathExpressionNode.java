package com.kiraged.script.ast.expression.math;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.ast.expression.InfixExpressionNode;
import com.kiraged.script.exception.NonMatchingType;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class MathExpressionNode extends InfixExpressionNode {

    private final MathOperator operator;

    public MathExpressionNode(MathOperator operator, ExpressionNode left, ExpressionNode right) {
        super(left, right);
        this.operator = operator;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        super.typeCheck(scope, returnType, returned);

        Type leftType = left.getType(scope);
        Type rightType = right.getType(scope);
        if (leftType == Type.BOOLEAN || rightType == Type.BOOLEAN) {
            throw new NonMatchingType("Not allowed to use boolean in math expression");
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        super.toBytecode(bytecode, scope);
        bytecode.add(operator.getInstruction(super.getType(scope)));
    }

    @Override
    public String toString() {
        return "MathExpressionNode{" +
                "operator=" + operator +
                '}';
    }


    public MathOperator getOperator() {
        return operator;
    }
}
