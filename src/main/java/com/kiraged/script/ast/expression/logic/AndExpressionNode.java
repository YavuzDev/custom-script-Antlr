package com.kiraged.script.ast.expression.logic;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.ast.expression.InfixExpressionNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class AndExpressionNode extends InfixExpressionNode {

    public AndExpressionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        super.typeCheck(scope, returnType, returned);
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        String falseLabel = "Label_" + hashCode() + "_false";
        String endLabel = "Label_" + hashCode() + "_end";

        left.toBytecode(bytecode, scope);
        bytecode.add("iconst_1");
        bytecode.add("if_icmpne " + falseLabel);
        right.toBytecode(bytecode, scope);
        bytecode.add("iconst_1");
        bytecode.add("if_icmpne " + falseLabel);
        bytecode.add("iconst_1");
        bytecode.add("goto " + endLabel);
        bytecode.add(falseLabel + ":");
        bytecode.add("iconst_0");

        bytecode.add(endLabel + ":");
    }

    @Override
    public Type getType(Scope scope) {
        return Type.BOOLEAN;
    }

    @Override
    public String toString() {
        return "AndExpressionNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
