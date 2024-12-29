

public class LoopEvaluator {

    public static void evaluateWhileLoop(String condition, String statement) {
        while (evaluateConditionExpression(condition)) {
            executeStatement(statement);
        }
    }

    private static boolean evaluateConditionExpression(String condition) {
        String[] tokens = condition.split(" ");
        int operand1 = Integer.parseInt(tokens[0]);
        String operator = tokens[1];
        int operand2 = Integer.parseInt(tokens[2]);

        switch (operator) {
            case ">":
                return operand1 > operand2;
            case "<":
                return operand1 < operand2;
            case "==":
                return operand1 == operand2;
            default:
                throw new IllegalArgumentException("Unsupported operator in condition: " + operator);
        }
    }

    private static void executeStatement(String statement) {
        if (statement.startsWith("LET")) {
            String[] parts = statement.split(" ");
            String variableName = parts[1];
            int value = Integer.parseInt(parts[3]);
            VariableStorage.assignVariable(variableName, value);
        }
    }
}
