import java.util.List;

public class ElectionAlgorithm {
    public void startElection() {
        System.out.println("Starting leader election...");
        int leader = (int) (Math.random() * 100); // Random leader ID
        System.out.println("Leader elected with ID: " + leader);
    }
}
