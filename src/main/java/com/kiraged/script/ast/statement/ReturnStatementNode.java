package com.kiraged.script.ast.statement;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.*;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class ReturnStatementNode extends StatementNode {

    private final ExpressionNode expression;

    public ReturnStatementNode(ExpressionNode expression) {
        this.expression = expression;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (returned) {
            throw new UnreachableCodeException("Not allowed to return under a return");
        }

        if (returnType == null) {
            throw new NotAllowedException("Not allowed to return inside global score");
        }

        if (expression != null) {
            expression.typeCheck(scope, returnType, false);

            Type expressionType = expression.getType(scope);

            if (expressionType == null) {
                throw new TypeNotFoundException("No type found for " + expression);
            }

            if (expressionType != returnType) {
                throw new NonMatchingType("No matching type for return statement");
            }
        } else {
            if (returnType != Type.VOID) {
                throw new NonMatchingType("Not allowed to return nothing at " + returnType);
            }
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        if (expression == null) {
            bytecode.add("return");
        } else {
            expression.toBytecode(bytecode, scope);
            Type type = expression.getType(scope);
            bytecode.add(type.getReturnStatement());
        }
    }

    @Override
    public String toString() {
        return "ReturnStatementNode{" +
                "expression=" + expression +
                "} ";
    }

    public ExpressionNode getExpression() {
        return expression;
    }
}
