package com.kiraged.script.ast.expression.compare;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.ast.expression.InfixExpressionNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class ComparisonExpressionNode extends InfixExpressionNode {

    private final ComparisonOperator operator;

    public ComparisonExpressionNode(ComparisonOperator operator, ExpressionNode left, ExpressionNode right) {
        super(left, right);
        this.operator = operator;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        super.typeCheck(scope, returnType, returned);
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        String elseLabel = "Label_" + hashCode() + "_else";
        String endLabel = "Label_" + hashCode() + "_end";

        super.toBytecode(bytecode, scope);
        Type type = super.getType(scope);
        if (type == Type.DOUBLE) {
            bytecode.add("dcmpl");
        }
        bytecode.add(operator.getIfCmp(type) + " " + elseLabel);
        bytecode.add("iconst_1");
        bytecode.add("goto " + endLabel);
        bytecode.add(elseLabel + ":");
        bytecode.add("iconst_0");
        bytecode.add(endLabel + ":");
    }

    @Override
    public Type getType(Scope scope) {
        return Type.BOOLEAN;
    }

    @Override
    public String toString() {
        return "ComparisonExpressionNode{" +
                "operator=" + operator +
                "} ";
    }

    public ComparisonOperator getOperator() {
        return operator;
    }
}
