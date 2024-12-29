

public class BasicInterpreter {
    public static void main(String[] args) {
        String code = "LET X = 10\n" +
                "LET Y = 5\n" +
                "IF X > Y THEN PRINT \"X is greater\"\n" +
                "IF Y > X THEN PRINT \"Y is greater\"\n" +
                "WHILE X > 0 DO LET X = X - 1\n" +
                "PRINT X";

        String[] lines = code.split("\n");

        for (String line : lines) {
            if (line.startsWith("LET")) {
                // Process LET statement (variable assignment)
                String[] parts = line.split(" ");
                String variableName = parts[1];
                int value = Integer.parseInt(parts[3]);
                VariableStorage.assignVariable(variableName, value);
            } else if (line.startsWith("IF")) {
                // Parse and evaluate IF statement
                String condition = line.substring(3, line.indexOf("THEN")).trim();
                String trueStatement = line.substring(line.indexOf("THEN") + 4).trim();
                ConditionalEvaluator.evaluateCondition(condition, trueStatement, null);
            } else if (line.startsWith("PRINT")) {
                String expression = line.substring(6);
                OutputEvaluator.print(expression);
            } else if (line.startsWith("WHILE")) {
                // Parse and execute WHILE loop
                String condition = line.substring(6, line.indexOf("DO")).trim();
                String statement = line.substring(line.indexOf("DO") + 2).trim();
                LoopEvaluator.evaluateWhileLoop(condition, statement);
            }
        }
    }
}
