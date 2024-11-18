public class DataConsistency {
    public void checkConsistency() {
        boolean isConsistent = DataReplication.replica1.equals(DataReplication.replica2);
        if (isConsistent) {
            System.out.println("Data is consistent across replicas.");
        } else {
            System.out.println("Data inconsistency detected!");
        }
    }
}
