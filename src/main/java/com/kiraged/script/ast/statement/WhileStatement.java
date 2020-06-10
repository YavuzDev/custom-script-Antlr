package com.kiraged.script.ast.statement;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.exception.UnreachableCodeException;
import com.kiraged.script.exception.WrongTypeException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class WhileStatement extends StatementNode {

    private final ExpressionNode expression;

    private final StatementNode statement;

    public WhileStatement(ExpressionNode expression, StatementNode statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (returned) {
            throw new UnreachableCodeException("Unable to reach at while loop");
        }

        expression.typeCheck(scope, returnType, false);
        statement.typeCheck(scope, returnType, false);

        Type expressionType = expression.getType(scope);

        if (expressionType != Type.BOOLEAN) {
            throw new WrongTypeException("Expected a boolean type here at the while loop");
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        String startLabel = "Label_" + hashCode() + "_start";
        String endLabel = "Label_" + hashCode() + "_end";
        bytecode.add(startLabel + ":");
        expression.toBytecode(bytecode, scope);
        bytecode.add("iconst_1");
        bytecode.add("if_icmpne " + endLabel);
        statement.toBytecode(bytecode, scope);
        bytecode.add("goto " + startLabel);
        bytecode.add(endLabel + ":");
    }

    @Override
    public String toString() {
        return "WhileStatement{" +
                "expression=" + expression +
                ", statement=" + statement +
                '}';
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    public StatementNode getStatement() {
        return statement;
    }
}
