package com.kiraged.script.jasmin;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JasminBytecode {
    /**
     * After successful compilation, this contains all Jasmin commands.
     */
    private ArrayList<String> jasminCode;

    /**
     * Name of the compiled class
     */
    private String className;

    /**
     * Create an instance with an empty list of Jasmin lines.
     */
    public JasminBytecode(String className) {
        this.className = className;
        this.jasminCode = new ArrayList<>();
    }

    /**
     * Create an instance that keeps track of the compiled Jasmin code. You can
     * pass this to AssembledClass::assemble() to actually build a class file
     * from this.
     *
     * @param className  The name of the class that was compiled.
     * @param jasminCode A list of Jasmin instructions.
     */
    public JasminBytecode(String className, ArrayList<String> jasminCode) {
        this.className = className;
        this.jasminCode = jasminCode;
    }

    /**
     * Add a line of Jasmin code.
     *
     * @param line A single line of Jasmin code.
     */
    public void add(String line) {
        jasminCode.add(line);
    }

    /**
     * Write the jasmin byte code (in text form) to a file. You can use this to
     * debug your code.
     *
     * @param jasminFileName Path to write the Jasmin code to.
     * @throws IOException if the file could not be written, e.g. because of
     *                     security rights.
     */
    public void writeJasminToFile(String jasminFileName) throws IOException {
        PrintWriter jasminOut = new PrintWriter(new FileWriter(jasminFileName));
        for (String line : jasminCode) {
            jasminOut.println(line);
        }
        jasminOut.close();
    }

    public String getClassName() {
        return className;
    }

    public List<String> getLines() {
        return jasminCode;
    }
}
