package com.kiraged.script.ast.expression;

import com.kiraged.script.Type;
import com.kiraged.script.ast.AstNode;
import com.kiraged.script.scope.Scope;

public abstract class ExpressionNode extends AstNode {
    public abstract Type getType(Scope scope);
}
