package com.kiraged.script.variable;

import com.kiraged.script.Type;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public abstract class Variable {

    private final Type type;

    public Variable(Type type) {
        this.type = type;
    }

    public abstract void toBytecode(JasminBytecode bytecode, Scope scope, boolean callExpression);

    public abstract void toByteCodeCall(JasminBytecode bytecode, Scope scope);

    public void toByteCodeInitialize(JasminBytecode bytecode, Scope scope) {

    }

    @Override
    public String toString() {
        return "Variable{" +
                "type=" + type +
                '}';
    }

    public Type getType() {
        return type;
    }
}
