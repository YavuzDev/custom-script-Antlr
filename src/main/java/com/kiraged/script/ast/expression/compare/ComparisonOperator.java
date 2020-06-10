package com.kiraged.script.ast.expression.compare;

import com.kiraged.script.Type;

public enum ComparisonOperator {
    EQUALS("if_icmpne", "ifne"),
    NOT_EQUALS("if_icmpeq", "ifeq"),
    GREATER_THAN("if_icmple", "ifle"),
    GREATER_THAN_EQUALS("if_icmplt", "iflt"),
    LOWER_THAN("if_icmpge", "ifge"),
    LOWER_THAN_EQUALS("if_icmpgt", "ifgt");

    private final String ifIcmp;

    private final String ifCmp;

    ComparisonOperator(String ifIcmp, String ifCmp) {
        this.ifIcmp = ifIcmp;
        this.ifCmp = ifCmp;
    }

    @Override
    public String toString() {
        return "ComparisonOperator{" +
                "ifIcmp='" + ifIcmp + '\'' +
                ", ifCmp='" + ifCmp + '\'' +
                '}';
    }

    public String getIfCmp(Type type) {
        if (type == Type.DOUBLE) {
            return ifCmp;
        }
        return ifIcmp;
    }

    public String getIfIcmp() {
        return ifIcmp;
    }

    public String getIfCmp() {
        return ifCmp;
    }
}
