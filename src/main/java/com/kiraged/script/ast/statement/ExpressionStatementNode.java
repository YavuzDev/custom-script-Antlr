package com.kiraged.script.ast.statement;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.exception.UnreachableCodeException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public class ExpressionStatementNode extends StatementNode {

    private final ExpressionNode expr;

    public ExpressionStatementNode(ExpressionNode expr) {
        this.expr = expr;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (returned) {
            throw new UnreachableCodeException("Unable to reach at " + expr);
        }

        expr.typeCheck(scope, returnType, false);
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        expr.toBytecode(bytecode, scope);
    }

    @Override
    public String toString() {
        return "ExpressionStatementNode{" +
                "expr=" + expr +
                '}';
    }

    public ExpressionNode getExpr() {
        return expr;
    }
}
