package com.kiraged.script.ast.statement;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.exception.UnreachableCodeException;
import com.kiraged.script.exception.WrongTypeException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class IfStatement extends StatementNode {

    private final ExpressionNode condition;

    private final StatementNode thenStatement;

    private final StatementNode elseStatement;

    public IfStatement(ExpressionNode condition, StatementNode thenStatement, StatementNode elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (returned) {
            throw new UnreachableCodeException("Unable to reach at " + condition);
        }

        condition.typeCheck(scope, returnType, false);
        thenStatement.typeCheck(scope, returnType, false);
        if (elseStatement != null) {
            elseStatement.typeCheck(scope, returnType, false);
        }

        Type conditionType = condition.getType(scope);

        if (conditionType != Type.BOOLEAN) {
            throw new WrongTypeException("Expected a boolean type here at the if statement");
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        String elseLabel = "Label_" + hashCode() + "_else";
        String endLabel = "Label_" + hashCode() + "_end";

        if (elseStatement == null) {
            elseLabel = endLabel;
        }

        condition.toBytecode(bytecode, scope);
        bytecode.add("iconst_1");
        bytecode.add("if_icmpne " + elseLabel);
        thenStatement.toBytecode(bytecode, scope);
        bytecode.add("goto " + endLabel);
        if (elseStatement != null) {
            bytecode.add(elseLabel + ":");
            elseStatement.toBytecode(bytecode, scope);
        }

        bytecode.add(endLabel + ":");
    }

    @Override
    public String toString() {
        return "IfStatement{" +
                "condition=" + condition +
                ", thenStatement=" + thenStatement +
                ", elseStatement=" + elseStatement +
                '}';
    }

    public ExpressionNode getCondition() {
        return condition;
    }

    public StatementNode getThenStatement() {
        return thenStatement;
    }

    public StatementNode getElseStatement() {
        return elseStatement;
    }
}
