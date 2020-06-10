package test;

import com.kiraged.script.Compiler;
import com.kiraged.script.exception.*;
import com.kiraged.script.jasmin.AssembleException;
import com.kiraged.script.jasmin.AssembledClass;
import com.kiraged.script.jasmin.JasminBytecode;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class CompilerTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void testValidVariables() throws TypeCheckException, IOException, AssembleException {
        AssembledClass assembledClass = compile("src/main/kiraged/valid/variables/Variables", "Variables");

        String[] output = getOutput(assembledClass);

        assertArrayEquals(new String[]{
                "550", "20.0", "100", "false", "true"
        }, output);

    }

    @Test
    public void testValidFunctions() throws TypeCheckException, IOException, AssembleException {
        AssembledClass assembledClass = compile("src/main/kiraged/valid/functions/Functions", "Functions");

        String[] output = getOutput(assembledClass);

        assertArrayEquals(new String[]{
                "20", "30", "100", "40100", "2000", "40", "50", "60.0", "200.0", "70.0", "80.0", "false", "false", "false", "true", "100", "10000"
        }, output);

    }

    @Test
    public void testValidInput() throws TypeCheckException, IOException, AssembleException {
        AssembledClass assembledClass = compile("src/main/kiraged/valid/input/Inputs", "Inputs");

        String randomInt = "100";

        systemInMock.provideLines("100", "200.0", "false", "100", randomInt);

        String[] output = getOutput(assembledClass);

        int value = Integer.parseInt(output[0]);
        assertTrue(value >= 0 && value <= Integer.parseInt(randomInt));
    }

    @Test
    public void testValidIf() throws TypeCheckException, IOException, AssembleException {
        AssembledClass assembledClass = compile("src/main/kiraged/valid/if/If", "If");

        String[] output = getOutput(assembledClass);

        assertArrayEquals(new String[]{"false", "true", "500", "true", "100"}, output);
    }

    @Test
    public void testValidWhile() throws TypeCheckException, IOException, AssembleException {
        AssembledClass assembledClass = compile("src/main/kiraged/valid/while/While", "While");

        String[] output = getOutput(assembledClass);

        assertArrayEquals(new String[]{
                "10", "9", "8", "7", "6", "5", "4", "3", "2", "1",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        }, output);
    }

    @Test(expected = NonMatchingType.class)
    public void testInvalidVariablesType() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/variables/VariablesType", "VariablesType");
    }

    @Test(expected = VariableNotFoundException.class)
    public void testInvalidVariablesFound() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/variables/VariablesNotFound", "VariablesNotFound");
    }

    @Test(expected = DuplicateVariableException.class)
    public void testInvalidVariablesDuplicate() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/variables/VariablesDuplicate", "VariablesDuplicate");
    }

    @Test(expected = ParserException.class)
    public void testInvalidVariablesParser() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/variables/VariablesParser", "VariablesParser");
    }

    @Test(expected = NotAllowedException.class)
    public void testInvalidVariablesInitialize() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/variables/VariablesInitialize", "VariablesInitialize");
    }

    @Test(expected = FunctionNotFoundException.class)
    public void testInvalidFunctionNotFound() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/functions/FunctionsNotFound", "FunctionsNotFound");
    }

    @Test(expected = NonMatchingType.class)
    public void testInvalidFunctionType() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/functions/FunctionsType", "FunctionsType");
    }

    @Test(expected = DuplicateParameterException.class)
    public void testInvalidFunctionParameter() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/functions/FunctionsParameter", "FunctionsParameter");
    }

    @Test(expected = NonMatchingType.class)
    public void testInvalidFunctionInput() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/functions/FunctionsInput", "FunctionsInput");
    }

    @Test(expected = UnreachableCodeException.class)
    public void testInvalidFunctionReturn() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/functions/FunctionsReturn", "FunctionsReturn");
    }

    @Test(expected = NotAllowedException.class)
    public void testInvalidFunctionReturnNotAllowed() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/functions/FunctionsReturnNotAllowed", "FunctionsReturnNotAllowed");
    }

    @Test(expected = WrongTypeException.class)
    public void testInvalidIfType() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/if/IfType", "IfType");
    }

    @Test(expected = WrongTypeException.class)
    public void testInvalidWhileType() throws TypeCheckException, IOException, AssembleException {
        compile("src/main/kiraged/invalid/while/WhileType", "WhileType");
    }

    private AssembledClass compile(String inputPath, String className) throws TypeCheckException, IOException, AssembleException {
        Compiler compiler = new Compiler();

        JasminBytecode jasminBytecode = compiler.compileFile(
                inputPath + ".txt",
                className);

        jasminBytecode.writeJasminToFile(inputPath + ".j");

        AssembledClass assembledClass = AssembledClass.assemble(jasminBytecode);
        int lastIndex = inputPath.lastIndexOf('/');
        String classFilename = inputPath.substring(0, lastIndex) + "/" + className + ".class";
        assembledClass.writeClassToFile(classFilename);
        return assembledClass;
    }

    private String[] getOutput(AssembledClass assembledClass) {
        SandBox s = new SandBox();
        s.runClass(assembledClass);
        return s.getOutput().toArray(new String[0]);
    }
}