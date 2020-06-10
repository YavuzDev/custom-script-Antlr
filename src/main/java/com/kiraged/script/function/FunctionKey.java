package com.kiraged.script.function;

import com.kiraged.script.Type;

import java.util.List;
import java.util.Objects;

public class FunctionKey {

    private final String name;

    private final List<Type> paramTypes;

    public FunctionKey(String name, List<Type> paramTypes) {
        this.name = name;
        this.paramTypes = paramTypes;
    }

    @Override
    public String toString() {
        return "FunctionKey{" +
                "name='" + name + '\'' +
                ", paramTypes=" + paramTypes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionKey that = (FunctionKey) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(paramTypes, that.paramTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, paramTypes);
    }

    public String getName() {
        return name;
    }

    public List<Type> getParamTypes() {
        return paramTypes;
    }
}
