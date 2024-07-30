import java.util.Scanner;

public class ATMSystem {

    // BankAccount class
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }
            return false;
        }
    }

    // ATM class
    static class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void displayMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit(scanner);
                        break;
                    case 3:
                        withdraw(scanner);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        private void checkBalance() {
            System.out.printf("Current balance: $%.2f\n", account.getBalance());
        }

        private void deposit(Scanner scanner) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposit successful.");
        }

        private void withdraw(Scanner scanner) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            }
        }
    }

    public static void main(String[] args) {
        // Initialize the bank account with a starting balance
        BankAccount account = new BankAccount(1000.00);

        // Create ATM instance with the bank account
        ATM atm = new ATM(account);

        // Start ATM menu
        atm.displayMenu();
    }
}
