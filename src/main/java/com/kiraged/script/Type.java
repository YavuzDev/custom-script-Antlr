package com.kiraged.script;

import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.ast.expression.variable.BooleanNode;
import com.kiraged.script.ast.expression.variable.DoubleNode;
import com.kiraged.script.ast.expression.variable.IntNode;

public enum Type {
    INT("int", "I", "istore", "iload", "ireturn", new IntNode("0")),
    DOUBLE("double", "D", "dstore", "dload", "dreturn", new DoubleNode("1.0")),
    BOOLEAN("boolean", "Z", "istore", "iload", "ireturn", new BooleanNode(false)),
    VOID("void", "V", "", "", "return", null);

    public static Type forKeyword(String keyword) {
        for (Type type : values()) {
            if (type.getKeyword().equals(keyword)) {
                return type;
            }
        }
        return null;
    }

    private final String keyword;

    private final String descriptor;

    private final String store;

    private final String load;

    private final String returnStatement;

    private final ExpressionNode defaultExpression;

    Type(String keyword, String descriptor, String store, String load, String returnStatement, ExpressionNode defaultExpression) {
        this.keyword = keyword;
        this.descriptor = descriptor;
        this.store = store;
        this.load = load;
        this.returnStatement = returnStatement;
        this.defaultExpression = defaultExpression;
    }

    @Override
    public String toString() {
        return "Type{" +
                "keyword='" + keyword + '\'' +
                ", descriptor='" + descriptor + '\'' +
                ", store='" + store + '\'' +
                ", load='" + load + '\'' +
                ", returnStatement='" + returnStatement + '\'' +
                ", defaultExpression=" + defaultExpression +
                '}';
    }

    public String getKeyword() {
        return keyword;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String getStore() {
        return store;
    }

    public String getLoad() {
        return load;
    }

    public String getReturnStatement() {
        return returnStatement;
    }

    public ExpressionNode getDefaultExpression() {
        return defaultExpression;
    }
}
