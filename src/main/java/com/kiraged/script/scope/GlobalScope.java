package com.kiraged.script.scope;

import com.kiraged.script.Type;
import com.kiraged.script.function.Function;
import com.kiraged.script.function.VirtualJavaFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalScope extends Scope {

    private static final List<String> CREATE_SCANNER_BYTECODE = Collections.unmodifiableList(Arrays.asList(
            "new java/util/Scanner",
            "dup",
            "getstatic java/lang/System/in Ljava/io/InputStream;",
            "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V"
    ));

    private static final List<String> CREATE_RANDOM_BYTECODE = Collections.unmodifiableList(Arrays.asList(
            "new java/util/Random",
            "dup",
            "invokespecial java/util/Random/<init>()V"
    ));

    private static final List<String> CREATE_PRINT_BYTECODE = Collections.singletonList(
            "getstatic java/lang/System/out Ljava/io/PrintStream;"
    );

    public GlobalScope(String className) {
        super(className);
        addRandomFunctions();
        addScannerFunctions();
        addPrintFunctions();
    }

    private Function createRandomFunction(Type type, List<Type> paramTypes, String suffix) {
        String paramsDesc = paramTypes.stream()
                .map(Type::getDescriptor)
                .collect(Collectors.joining());
        return new VirtualJavaFunction(
                CREATE_RANDOM_BYTECODE,
                "java/util/Random",
                "next" + suffix,
                "(" + paramsDesc + ")" + type.getDescriptor(),
                type
        );
    }

    private void addRandomFunction(Type type, Type paramType, String suffix) {
        addRandomFunction(type, Collections.singletonList(paramType), suffix);
    }

    private void addRandomFunction(Type type, String suffix) {
        addRandomFunction(type, Collections.emptyList(), suffix);
    }

    private void addRandomFunction(Type type, List<Type> paramTypes, String suffix) {
        addFunction("random" + suffix, paramTypes, createRandomFunction(type, paramTypes, suffix));
    }

    private void addRandomFunctions() {
        addRandomFunction(Type.INT, Type.INT, "Int");
        addRandomFunction(Type.INT, "Int");
        addRandomFunction(Type.DOUBLE, "Double");
        addRandomFunction(Type.BOOLEAN, "Boolean");
    }


    private Function createAskFunction(Type type, String suffix) {
        return new VirtualJavaFunction(
                CREATE_SCANNER_BYTECODE,
                "java/util/Scanner",
                "next" + suffix,
                "()" + type.getDescriptor(),
                type
        );
    }

    private void addAskFunction(Type type, String suffix) {
        addFunction("ask" + suffix, Collections.emptyList(), createAskFunction(type, suffix));
    }

    private void addScannerFunctions() {
        addAskFunction(Type.INT, "Int");
        addAskFunction(Type.DOUBLE, "Double");
        addAskFunction(Type.BOOLEAN, "Boolean");
    }

    private void addPrintFunctions() {
        for (Type type : Type.values()) {
            if (type == Type.VOID) {
                continue;
            }
            addFunction("print",
                    Collections.singletonList(type),
                    new VirtualJavaFunction(
                            CREATE_PRINT_BYTECODE,
                            "java/io/PrintStream",
                            "println",
                            "(" + type.getDescriptor() + ")" + Type.VOID.getDescriptor(),
                            Type.VOID
                    ));
        }

        addFunction("print",
                Collections.emptyList(),
                new VirtualJavaFunction(
                        CREATE_PRINT_BYTECODE,
                        "java/io/PrintStream",
                        "println",
                        "()" + Type.VOID.getDescriptor(),
                        Type.VOID
                ));
    }
}
