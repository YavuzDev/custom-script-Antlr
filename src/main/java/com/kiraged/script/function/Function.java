package com.kiraged.script.function;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

import java.util.List;

public abstract class Function {

    private final Type returnType;

    public Function(Type returnType) {
        this.returnType = returnType;
    }

    public abstract void toBytecode(JasminBytecode bytecode, Scope scope, List<ExpressionNode> args);

    @Override
    public String toString() {
        return "Function{" +
                "returnType=" + returnType +
                '}';
    }

    public Type getReturnType() {
        return returnType;
    }
}
