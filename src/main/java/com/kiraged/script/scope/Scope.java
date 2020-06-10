package com.kiraged.script.scope;

import com.kiraged.script.Type;
import com.kiraged.script.function.Function;
import com.kiraged.script.function.FunctionKey;
import com.kiraged.script.variable.StaticVariable;
import com.kiraged.script.variable.Variable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Scope {

    private final String className;

    private final Scope parentScope;

    private final Map<FunctionKey, Function> functions;

    private final Map<String, Variable> variables;

    public Scope(String className) {
        this(className, null);
    }

    public Scope(String className, Scope parentScope) {
        this.className = className;
        this.parentScope = parentScope;
        this.functions = new HashMap<>();
        this.variables = new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        return "Scope{" +
                "className='" + className + '\'' +
                ", parentScope=" + parentScope +
                ", functions=" + functions +
                ", variable=" + variables +
                '}';
    }

    public boolean addFunction(String name, List<Type> types, Function function) {
        if (getFunction(name, types) != null) {
            return false;
        }
        functions.put(new FunctionKey(name, types), function);
        return true;
    }

    public Function getFunction(String name, List<Type> types) {
        Function function = functions.get(new FunctionKey(name, types));
        if (function == null && parentScope != null) {
            return parentScope.getFunction(name, types);
        }
        return function;
    }

    public boolean addVariable(String name, Variable variable) {
        Variable toCheck = getVariable(name);

        if (toCheck instanceof StaticVariable && variable instanceof StaticVariable) {
            StaticVariable toCheckStatic = (StaticVariable) toCheck;
            StaticVariable variableStatic = (StaticVariable) variable;

            if (toCheckStatic.getName().equals(variableStatic.getName())) {
                return false;
            }
        }

        if (toCheck != null && !(toCheck instanceof StaticVariable)) {
            return false;
        }
        variables.put(name, variable);
        return true;
    }

    public Variable getVariable(String name) {
        Variable variable = variables.get(name);
        if (variable == null && parentScope != null) {
            return parentScope.getVariable(name);
        }
        return variable;
    }

    public int getTotalVariablesInScope() {
        return variables.size();
    }

    public boolean inGlobalScope() {
        return parentScope == null;
    }

    public String getClassName() {
        return className;
    }

    public Scope getParentScope() {
        return parentScope;
    }

    public Map<FunctionKey, Function> getFunctions() {
        return functions;
    }

    public Map<String, Variable> getVariables() {
        return variables;
    }
}
