package com.kiraged.script.ast.statement;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.*;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;
import com.kiraged.script.variable.LocalVariable;
import com.kiraged.script.variable.StaticVariable;
import com.kiraged.script.variable.Variable;

public class VariableDeclarationNode extends StatementNode {

    private Type type;

    private final String name;

    private ExpressionNode expression;

    public VariableDeclarationNode(Type type, String name, ExpressionNode expression) {
        this.type = type;
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (returned) {
            throw new UnreachableCodeException("Unable to reach " + name);
        }

        if (expression == null) {
            setExpression();

            if (expression == null) {
                throw new NotAllowedException("You have to initialize a var variable");
            }
        }

        expression.typeCheck(scope, returnType, false);

        Type expressionType = expression.getType(scope);

        if (expressionType == null) {
            throw new TypeNotFoundException("Type not found for expression at " + name);
        }

        if (expressionType == Type.VOID) {
            throw new NonMatchingType("You're not allowed to assign a void type to variables at variable " + name);
        }

        if (expressionType != type && type != null) {
            throw new NonMatchingType("Type " + expressionType + " and type " + type + " don't match for " + name);
        }

        if (type == null) {
            type = expressionType;
        }

        Variable variable = scope.getVariable(name);

        if (scope.inGlobalScope()) {
            if (variable != null) {
                throw new DuplicateVariableException("A variable with the name " + name + " already exists in this scope");
            }
        } else {
            if (variable != null && !(variable instanceof StaticVariable)) {
                throw new DuplicateVariableException("A variable with the name " + name + " already exists in this scope");
            }
        }

        addVariable(scope);
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        if (expression == null) {
            setExpression();
        }

        if (type == null) {
            type = expression.getType(scope);
        }

        if (scope.inGlobalScope()) {
            addVariable(scope);
        } else {
            Variable localVariable = addVariable(scope);
            localVariable.toBytecode(bytecode, scope, true);
        }
    }

    @Override
    public String toString() {
        return "VariableDeclarationNode{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", expression=" + expression +
                '}';
    }

    private Variable addVariable(Scope scope) {
        if (scope.inGlobalScope()) {
            StaticVariable staticVariable = new StaticVariable(type, name, expression);
            scope.addVariable(name, staticVariable);
            return staticVariable;
        }
        LocalVariable localVariable = new LocalVariable(type, scope.getTotalVariablesInScope(), expression);
        scope.addVariable(name, localVariable);
        return localVariable;
    }

    private void setExpression() {
        if (type != null) {
            expression = type.getDefaultExpression();
        }
    }


    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public ExpressionNode getExpression() {
        return expression;
    }
}
