package com.kiraged.script.ast.expression.math;

import com.kiraged.script.Type;

public enum MathOperator {
    ADDITION("iadd", "dadd"),
    SUBTRACTION("isub", "dsub"),
    MULTIPLICATION("imul", "dmul"),
    DIVISION("idiv", "ddiv");

    private final String intInstruction;

    private final String doubleInstruction;

    MathOperator(String intInstruction, String doubleInstruction) {
        this.intInstruction = intInstruction;
        this.doubleInstruction = doubleInstruction;
    }

    @Override
    public String toString() {
        return "MathOperator{" +
                "intInstruction='" + intInstruction + '\'' +
                ", doubleInstruction='" + doubleInstruction + '\'' +
                '}';
    }

    public String getInstruction(Type type) {
        if (type == Type.DOUBLE) {
            return doubleInstruction;
        }
        return intInstruction;
    }

    public String getIntInstruction() {
        return intInstruction;
    }

    public String getDoubleInstruction() {
        return doubleInstruction;
    }
}
