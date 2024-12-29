

public class ConditionalEvaluator {

    public static void evaluateCondition(String condition, String trueStatement, String falseStatement) {
        boolean result = evaluateConditionExpression(condition);

        if (result) {
            executeStatement(trueStatement);
        } else if (falseStatement != null) {
            executeStatement(falseStatement);
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
        if (statement.startsWith("PRINT")) {
            OutputEvaluator.print(statement.substring(6).trim());
        } else if (statement.startsWith("LET")) {
            String[] parts = statement.split(" ");
            String variableName = parts[1];
            int value = Integer.parseInt(parts[3]);
            VariableStorage.assignVariable(variableName, value);
        }
    }
}
