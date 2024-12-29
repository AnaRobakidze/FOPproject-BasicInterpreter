

import java.util.HashMap;
import java.util.Map;

public class VariableStorage {
    private final Map<String, Integer> variables;

    public VariableStorage() {
        variables = new HashMap<>();
    }

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }

    public int getVariable(String name) {
        return variables.getOrDefault(name, 0); // default value is 0 if the variable is not found
    }
}
