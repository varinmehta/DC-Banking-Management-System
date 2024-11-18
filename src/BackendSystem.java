public class BackendSystem {
    private ClockSynchronization clockSync = new ClockSynchronization();
    private ElectionAlgorithm election = new ElectionAlgorithm();
    private MutualExclusion mutualExclusion = new MutualExclusion();
    private DataReplication dataReplication = new DataReplication();
    private DataConsistency consistency = new DataConsistency();

    public void handleNewAccount(BankAccount account) {
        clockSync.synchronizeClocks(); // Synchronize clocks for the new account
        election.startElection(); // Elect leader for managing distributed accounts
        dataReplication.replicateData(account.getAccountNumber(), account.getBalance());
    }

    public void handleTransaction(BankAccount account) {
        mutualExclusion.executeCriticalSection(); // Ensure mutual exclusion during transactions
        dataReplication.replicateData(account.getAccountNumber(), account.getBalance());
    }

    public void checkConsistency() {
        consistency.checkConsistency(); // Verify data consistency
    }
}
