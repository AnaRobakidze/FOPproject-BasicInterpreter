package com;

import java.util.HashMap;
import java.util.Map;

public class BasicInterpreter {
    private final Map<String, Integer> variables = new HashMap<>();

    // Evaluates a single line of BASIC-like code
    public void evalLine(String line) {
        line = line.trim(); // Remove extra spaces
        if (line.startsWith("puts") || line.startsWith("print")) {
            handlePrint(line);
        } else if (line.contains("=")) {
            handleAssignment(line);
        } else if (line.startsWith("while")) {
            handleWhile(line);
        } else if (line.startsWith("if")) {
            handleIf(line);
        } else {
            throw new RuntimeException("Unsupported statement: " + line);
        }
    }

    // Handles PRINT or PUTS statements
    private void handlePrint(String line) {
        String expr = line.replaceFirst("(puts|print)", "").trim(); // Extract expression
        System.out.println(evaluateExpression(expr)); // Print evaluated result
    }

    // Handles variable assignments
    private void handleAssignment(String line) {
        String[] parts = line.split("=", 2);
        String varName = parts[0].trim();
        String expression = parts[1].trim();
        variables.put(varName, evaluateExpression(expression));
    }

    // Evaluates a BASIC-like expression
    private int evaluateExpression(String expr) {
        if (expr.matches("-?\\d+")) {
            return Integer.parseInt(expr); // Numeric value
        } else if (variables.containsKey(expr)) {
            return variables.get(expr); // Variable value
        } else if (expr.contains("%") || expr.contains("+") || expr.contains("-") || expr.contains("*") || expr.contains("/")) {
            return evaluateArithmetic(expr); // Arithmetic expression
        } else {
            throw new RuntimeException("Unsupported expression: " + expr);
        }
    }

    // Evaluates simple arithmetic expressions
    private int evaluateArithmetic(String expr) {
        String[] tokens;
        if (expr.contains("+")) {
            tokens = expr.split("\\+");
            return evaluateExpression(tokens[0].trim()) + evaluateExpression(tokens[1].trim());
        } else if (expr.contains("-")) {
            tokens = expr.split("-");
            return evaluateExpression(tokens[0].trim()) - evaluateExpression(tokens[1].trim());
        } else if (expr.contains("*")) {
            tokens = expr.split("\\*");
            return evaluateExpression(tokens[0].trim()) * evaluateExpression(tokens[1].trim());
        } else if (expr.contains("/")) {
            tokens = expr.split("/");
            return evaluateExpression(tokens[0].trim()) / evaluateExpression(tokens[1].trim());
        } else if (expr.contains("%")) {
            tokens = expr.split("%");
            return evaluateExpression(tokens[0].trim()) % evaluateExpression(tokens[1].trim());
        } else {
            throw new RuntimeException("Invalid arithmetic expression: " + expr);
        }
    }

    // Handles the WHILE loop (very basic, assuming simple cases)
    private void handleWhile(String line) {
        String condition = line.substring(6, line.indexOf("end")).trim();
        while (evaluateExpression(condition) != 0) {
            evalLine(line); // Execute the code inside the loop
        }
    }

    // Handles the IF statement (basic implementation)
    private void handleIf(String line) {
        String condition = line.substring(2, line.indexOf("then")).trim();
        if (evaluateExpression(condition) != 0) {
            evalLine(line.substring(line.indexOf("then") + 4).trim()); // Execute the code after THEN
        }
    }

    // Executes a BASIC-like program block (multiple lines)
    public void evalBlock(String code) {
        String[] lines = code.split("\n");
        for (String line : lines) {
            evalLine(line.trim());
        }
    }
}
