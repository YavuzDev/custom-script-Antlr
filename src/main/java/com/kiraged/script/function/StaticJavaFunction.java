package com.kiraged.script.function;

import com.kiraged.script.Type;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

import java.util.List;

public class StaticJavaFunction extends Function {

    private final String owner;

    private final String name;

    private final String desc;

    public StaticJavaFunction(String owner, String name, String desc, Type type) {
        super(type);
        this.owner = owner;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public void toBytecode(JasminBytecode bytecode, Scope scope, List<ExpressionNode> args) {
        args.forEach(arg -> {
            arg.toBytecode(bytecode, scope);
        });
        bytecode.add("invokestatic " + owner + "/" + name + desc);
    }

    @Override
    public String toString() {
        return "StaticJavaFunction{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                "} ";
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
