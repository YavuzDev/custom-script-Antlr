package com.kiraged.script.ast.expression.variable;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.exception.VariableNotFoundException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;
import com.kiraged.script.variable.Variable;

public class VariableNode extends ExpressionNode {

    private final String name;

    public VariableNode(String name) {
        this.name = name;
    }

    private Variable getVariable(Scope scope) {
        return scope.getVariable(name);
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (getVariable(scope) == null) {
            throw new VariableNotFoundException("No variable with the name " + name + " was found in this scope");
        }
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        getVariable(scope).toByteCodeCall(bytecode, scope);
    }

    @Override
    public Type getType(Scope scope) {
        return getVariable(scope).getType();
    }

    @Override
    public String toString() {
        return "VariableNode{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
