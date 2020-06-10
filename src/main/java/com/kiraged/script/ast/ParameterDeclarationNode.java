package com.kiraged.script.ast;

import com.kiraged.script.Type;
import com.kiraged.script.exception.DuplicateParameterException;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.exception.TypeNotFoundException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;
import com.kiraged.script.variable.LocalVariable;
import com.kiraged.script.variable.StaticVariable;
import com.kiraged.script.variable.Variable;

public class ParameterDeclarationNode extends AstNode {

    private final Type type;

    private final String name;

    public ParameterDeclarationNode(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException {
        if (type == null) {
            throw new TypeNotFoundException("No type found at " + name);
        }

        Variable variable = scope.getVariable(name);

        if (variable != null && !(variable instanceof StaticVariable)) {
            throw new DuplicateParameterException("A parameter with this name " + name + " already exists");
        }

        addVariable(scope);
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope) {
        Variable localVariable = addVariable(scope);
        localVariable.toByteCodeCall(bytecode, scope);
        localVariable.toBytecode(bytecode, scope, true);
    }

    private Variable addVariable(Scope scope) {
        LocalVariable localVariable = new LocalVariable(type, scope.getTotalVariablesInScope(), null);
        scope.addVariable(name, localVariable);
        return localVariable;
    }

    @Override
    public String toString() {
        return "ParameterDeclarationNode{" +
                "type=" + type +
                ", name='" + name + '\'' +
                "} ";
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
