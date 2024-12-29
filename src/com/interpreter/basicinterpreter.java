

public class BasicInterpreter {

    public void eval(String code) {
        // Split code by semicolon, representing separate statements
        String[] lines = code.split(";");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // Handle variable assignment with LET
            if (line.startsWith("LET")) {
                handleAssignment(line);
            }
            // Handle PRINT statements
            else if (line.startsWith("PRINT")) {
                handlePrint(line);
            }
        }
    }

    private void handleAssignment(String line) {
        // Extract variable name and expression
        String[] parts = line.split("=");
        String varName = parts[0].replace("LET", "").trim();
        String expression = parts[1].trim();

        // Handle arithmetic (only addition in this simple example)
        String[] numbers = expression.split("\\+");
        int value = 0;
        for (String num : numbers) {
            value += Integer.parseInt(num.trim());
        }

        // Store the variable in memory
        VariableStorage.assignVariable(varName, value);
    }

    private void handlePrint(String line) {
        // Extract variable name from PRINT statement
        String varName = line.substring(line.indexOf('(') + 1, line.indexOf(')')).trim();
        Integer value = VariableStorage.getVariableValue(varName);

        if (value != null) {
            System.out.println(value);
        } else {
            System.out.println("Variable " + varName + " not defined.");
        }
    }

    public static void main(String[] args) {
        BasicInterpreter interpreter = new BasicInterpreter();

        // Example program to sum numbers and print the result
        String program = """
            LET sum = 10 + 20;
            PRINT(sum);
        """;

        // Execute the program
        interpreter.eval(program);
    }
}
