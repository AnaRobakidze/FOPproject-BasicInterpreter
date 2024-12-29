

import java.util.HashMap;
import java.util.Map;

public class VariableStorage {
    private static final Map<String, Integer> variables = new HashMap<>();

    public static void assignVariable(String name, int value) {
        variables.put(name, value);
    }

    public static Integer getVariableValue(String name) {
        return variables.get(name);
    }

    public static boolean isVariableDefined(String name) {
        return variables.containsKey(name);
    }
}
