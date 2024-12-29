

import java.util.Arrays;

public class BasicInterpreter {
    private final VariableStorage variableStorage;

    public BasicInterpreter() {
        variableStorage = new VariableStorage();
    }

    public void eval(String code) {
        String[] lines = code.split("\n");

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.startsWith("LET")) {
                handleAssignment(line);
            } else if (line.startsWith("IF")) {
                handleIfStatement(line);
            } else if (line.startsWith("WHILE")) {
                handleWhileLoop(line);
            } else if (line.startsWith("PRINT")) {
                handlePrintStatement(line);
            }
        }
    }

    private void handleAssignment(String line) {
        // Syntax: LET <variable> = <expression>
        String[] parts = line.substring(4).split("=");
        String varName = parts[0].trim();
        String expression = parts[1].trim();
        int value = evaluateExpression(expression);
        variableStorage.setVariable(varName, value);
    }

    private void handleIfStatement(String line) {
        // Syntax: IF <condition> THEN <statement> [ELSE <statement>]
        String condition = line.substring(2, line.indexOf("THEN")).trim();
        String statement = line.substring(line.indexOf("THEN") + 4).trim();

        // Evaluate the condition (we only support simple equality checks for now)
        String[] conditionParts = condition.split("=");
        String leftVar = conditionParts[0].trim();
        String rightVar = conditionParts[1].trim();

        boolean conditionMet = variableStorage.getVariable(leftVar) == variableStorage.getVariable(rightVar);

        if (conditionMet) {
            System.out.println(statement);
        }
    }

    private void handleWhileLoop(String line) {
        // Syntax: WHILE <condition> DO <statement>
        String condition = line.substring(6, line.indexOf("DO")).trim();
        String statement = line.substring(line.indexOf("DO") + 2).trim();

        // Handle basic condition (only equality for simplicity)
        String[] conditionParts = condition.split("=");
        String leftVar = conditionParts[0].trim();
        String rightVar = conditionParts[1].trim();

        while (variableStorage.getVariable(leftVar) == variableStorage.getVariable(rightVar)) {
            System.out.println(statement);
        }
    }

    private void handlePrintStatement(String line) {
        // Syntax: PRINT <expression>
        String expression = line.substring(5).trim();
        int value = evaluateExpression(expression);
        System.out.println(value);
    }

    private int evaluateExpression(String expression) {
        // Simple evaluator for arithmetic expressions (supports addition only for simplicity)
        String[] parts = expression.split("\\+");
        int result = Arrays.stream(parts)
                .map(String::trim)
                .mapToInt(part -> {
                    try {
                        return Integer.parseInt(part);
                    } catch (NumberFormatException e) {
                        return variableStorage.getVariable(part);
                    }
                })
                .sum();
        return result;
    }

    public static void main(String[] args) {
        BasicInterpreter interpreter = new BasicInterpreter();

        String program = """
            LET X = 10 + 20;
            LET Y = 5 + 10;
            IF X = Y THEN PRINT "Equal";
            WHILE X = Y DO PRINT "Looping";
            PRINT X;
        """;

        interpreter.eval(program);
    }
}
