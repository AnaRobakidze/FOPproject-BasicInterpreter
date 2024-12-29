

public class ArithmeticEvaluator {

    public static int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        int operand1 = getOperandValue(tokens[0]);
        String operator = tokens[1];
        int operand2 = getOperandValue(tokens[2]);

        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "%":
                return operand1 % operand2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private static int getOperandValue(String operand) {
        if (VariableStorage.isVariableDefined(operand)) {
            return VariableStorage.getVariableValue(operand);
        }
        return Integer.parseInt(operand);
    }
}
