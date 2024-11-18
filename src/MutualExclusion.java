public class MutualExclusion {
    private boolean inCriticalSection = false;

    public void executeCriticalSection() {
        if (!inCriticalSection) {
            inCriticalSection = true;
            System.out.println("Entering critical section...");
            // Simulate critical section work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exiting critical section...");
            inCriticalSection = false;
        } else {
            System.out.println("Critical section is currently locked.");
        }
    }
}
