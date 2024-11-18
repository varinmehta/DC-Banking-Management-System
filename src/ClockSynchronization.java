import java.util.List;
import java.util.ArrayList;

public class ClockSynchronization {
    private List<Integer> clocks = new ArrayList<>();

    public void synchronizeClocks() {
        System.out.println("Synchronizing clocks...");
        clocks.add((int) (System.currentTimeMillis() % 1000)); // Example clock values
        int average = clocks.stream().mapToInt(Integer::intValue).sum() / clocks.size();
        clocks.replaceAll(clock -> average);
        System.out.println("Clocks synchronized to: " + average);
    }
}
