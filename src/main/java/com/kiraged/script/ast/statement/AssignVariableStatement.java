package com.kiraged.script.ast.statement;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.*;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;
import com.kiraged.script.variable.Variable;

public class AssignVariableStatement extends StatementNode {

    private final String name;

    private final ExpressionNode expression;

    public AssignVariableStatement(String name, ExpressionNode expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (returned) {
            throw new UnreachableCodeException("Unable to reach at " + name);
        }

        expression.typeCheck(scope, returnType, false);

        Type expressionType = expression.getType(scope);
        if (expressionType == null) {
            throw new TypeNotFoundException("Type not found for expression at " + name);
        }

        Variable variable = scope.getVariable(name);

        if (variable == null) {
            throw new VariableNotFoundException("Variable with the name " + name + " wasn't found");
        }

        Type variableType = variable.getType();
        if (expressionType != variableType) {
            throw new NonMatchingType("Type " + expressionType + " and type " + variableType + " don't match for " + name);
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        expression.toBytecode(bytecode, scope);
        Variable variable = scope.getVariable(name);
        variable.toBytecode(bytecode, scope, false);
    }

    @Override
    public String toString() {
        return "AssignVariableStatement{" +
                "name='" + name + '\'' +
                ", expression=" + expression +
                '}';
    }

    public String getName() {
        return name;
    }

    public ExpressionNode getExpression() {
        return expression;
    }
}
