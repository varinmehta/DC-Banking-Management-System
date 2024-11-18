import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class RMIManager {
    public static void startRMI() throws Exception {
        BankImpl bank = new BankImpl();
        Naming.rebind("BankService", bank);
        System.out.println("RMI Server started...");
    }
}

interface Bank extends Remote {
    String getAccountDetails(int accountId) throws RemoteException;
}

class BankImpl extends UnicastRemoteObject implements Bank {
    public BankImpl() throws RemoteException {}

    @Override
    public String getAccountDetails(int accountId) throws RemoteException {
        return "Account ID: " + accountId + ", Balance: $1000";
    }
}
