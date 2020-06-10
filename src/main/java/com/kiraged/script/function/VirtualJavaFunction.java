package com.kiraged.script.function;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

import java.util.List;

public class VirtualJavaFunction extends Function {

    private final List<String> getInstanceCode;

    private final String owner;

    private final String name;

    private final String desc;

    public VirtualJavaFunction(List<String> getInstanceCode, String owner, String name, String desc, Type type) {
        super(type);
        this.getInstanceCode = getInstanceCode;
        this.owner = owner;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope, List<ExpressionNode> args) {
        getInstanceCode.forEach(bytecode::add);
        args.forEach(arg -> arg.toBytecode(bytecode, scope));
        bytecode.add("invokevirtual " + owner + "/" + name + desc);
    }

    @Override
    public String toString() {
        return "VirtualJavaFunction{" +
                "getInstanceCode=" + getInstanceCode +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                "} ";
    }

    public List<String> getGetInstanceCode() {
        return getInstanceCode;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
