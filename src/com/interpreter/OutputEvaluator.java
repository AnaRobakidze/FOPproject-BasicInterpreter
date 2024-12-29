

public class OutputEvaluator {
    public static void print(String expression) {
        // Print the evaluated value of the expression
        int result = ArithmeticEvaluator.evaluate(expression);
        System.out.println(result);
    }
}
