import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingSystemMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();
        BackendSystem backend = new BackendSystem();

        System.out.println("Welcome to the Banking Management System!");
        boolean running = true;

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNumber = sc.next();
                    System.out.print("Enter Account Holder's Name: ");
                    sc.nextLine(); // Consume newline
                    String accHolder = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = sc.nextDouble();

                    BankAccount account = new BankAccount(accNumber, accHolder, initialBalance);
                    accounts.put(accNumber, account);
                    backend.handleNewAccount(account);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNumber = sc.next();
                    if (accounts.containsKey(accNumber)) {
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = sc.nextDouble();
                        accounts.get(accNumber).deposit(depositAmount);
                        backend.handleTransaction(accounts.get(accNumber));
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNumber = sc.next();
                    if (accounts.containsKey(accNumber)) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawalAmount = sc.nextDouble();
                        accounts.get(accNumber).withdraw(withdrawalAmount);
                        backend.handleTransaction(accounts.get(accNumber));
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNumber = sc.next();
                    if (accounts.containsKey(accNumber)) {
                        accounts.get(accNumber).checkBalance();
                        backend.checkConsistency();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the Banking Management System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
