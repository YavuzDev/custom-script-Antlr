package com.kiraged.script.ast;

import com.kiraged.script.Type;
import com.kiraged.script.exception.TypeCheckException;
import com.kiraged.script.jasmin.JasminBytecode;
import com.kiraged.script.scope.Scope;

public abstract class AstNode {

    public abstract void typeCheck(Scope scope, Type returnType, boolean returned) throws TypeCheckException;

    public abstract void toBytecode(JasminBytecode bytecode, Scope scope);

}
