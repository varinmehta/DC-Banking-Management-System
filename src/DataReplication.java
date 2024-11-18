import java.util.HashMap;
import java.util.Map;

public class DataReplication {
    static Map<String, String> replica1 = new HashMap<>();
    static Map<String, String> replica2 = new HashMap<>();

    public void replicateData(String key, double value) {
        String strValue = String.valueOf(value);
        replica1.put(key, strValue);
        replica2.put(key, strValue);
        System.out.println("Data replicated for account " + key + ": " + strValue);
    }
}
