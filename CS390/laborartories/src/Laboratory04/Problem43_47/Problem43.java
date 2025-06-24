package Laboratory04.Problem43_47;

import Laboratory04.Problem43_47.employeeinfo.Account;
import Laboratory04.Problem43_47.employeeinfo.Employee;

import java.util.Scanner;

public class Problem43 {
    private Employee[] emps;
    private Scanner sc;

    public Problem43() {
        emps = new Employee[3];
        // Initialize employees as per Lab 3-2 (or similar)
        emps[0] = new Employee("Jim Daley", 2000, 9, 4);
        emps[0].createNewChecking(10100);
        emps[0].createNewSavings(1000);
        emps[0].createNewRetirement(9300);

        emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
        emps[1].createNewChecking(33000);
        emps[1].createNewSavings(11000);
        // Bob has no retirement account initially for variety

        emps[2] = new Employee("Susan Randolph", 1995, 7, 9);
        emps[2].createNewChecking(11000);
        emps[2].createNewSavings(13000);
        emps[2].createNewRetirement(10000);

        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Problem43 m = new Problem43();
        m.runConsole();
    }

    public void runConsole() {
        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("A. See a report of all accounts.");
            System.out.println("B. Make a deposit.");
            System.out.println("C. Make a withdrawal.");
            System.out.println("X. Exit application.");
            System.out.print("Make a selection (A/B/C/X): ");
            String choice = sc.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    displayReport();
                    break;
                case "B":
                    handleTransaction(TransactionType.DEPOSIT);
                    break;
                case "C":
                    handleTransaction(TransactionType.WITHDRAWAL);
                    break;
                case "X":
                    System.out.println("Exiting application. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void displayReport() {
        System.out.println("\n--- ACCOUNT REPORT ---");
        if (emps == null || emps.length == 0) {
            System.out.println("No employee data available.");
            return;
        }
        for (Employee e : emps) {
            if (e != null) {
                System.out.print(e.getFormattedAcctInfo());
            }
        }
        System.out.println("--- END OF REPORT ---");
    }

    private enum TransactionType {DEPOSIT, WITHDRAWAL}

    private void handleTransaction(TransactionType type) {
        System.out.println("\n--- " + type.toString() + " ---");
        if (emps == null || emps.length == 0) {
            System.out.println("No employees available for transaction.");
            return;
        }

        // List employees
        System.out.println("Employees:");
        for (int i = 0; i < emps.length; i++) {
            if (emps[i] != null) {
                System.out.println(i + ". " + emps[i].getName());
            }
        }
        System.out.print("Select an employee (type a number): ");
        int empIndex;
        try {
            empIndex = Integer.parseInt(sc.nextLine());
            if (empIndex < 0 || empIndex >= emps.length || emps[empIndex] == null) {
                System.out.println("Invalid employee selection.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please type a number.");
            return;
        }

        Employee selectedEmp = emps[empIndex];
        System.out.println("Selected Employee: " + selectedEmp.getName());

        // List accounts for the selected employee
        MyStringList accountNames = selectedEmp.getNamesOfAccounts();
        if (accountNames.isEmpty()) {
            System.out.println(selectedEmp.getName() + " has no accounts.");
            return;
        }
        System.out.println("Accounts for " + selectedEmp.getName() + ":");
        for (int i = 0; i < accountNames.size(); i++) {
            System.out.println(i + ". " + accountNames.get(i)); // Includes type and ID
        }
        System.out.print("Select an account (type a number): ");
        int accIndex;
        try {
            accIndex = Integer.parseInt(sc.nextLine());
            if (accIndex < 0 || accIndex >= accountNames.size()) {
                System.out.println("Invalid account selection.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please type a number.");
            return;
        }

        Account targetAccount = selectedEmp.getAccount(accIndex); // Helper to get the actual Account object
        if (targetAccount == null) { // Should not happen if accIndex is valid based on accountNames.size()
            System.out.println("Error: Could not retrieve selected account.");
            return;
        }

        System.out.print(type.toString() + " amount: ");
        double amount;
        try {
            amount = Double.parseDouble(sc.nextLine());
            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format.");
            return;
        }

        if (type == TransactionType.DEPOSIT) {
            selectedEmp.deposit(accIndex, amount);
            // The deposit method itself prints confirmation.
            // We can add a summary here if needed.
            System.out.printf("$%.2f has been processed for deposit into the %s account of %s.%n",
                    amount, targetAccount.getAcctType().toString(), selectedEmp.getName());
        } else { // WITHDRAWAL
            boolean success = selectedEmp.withdraw(accIndex, amount);
            // The withdraw method prints details.
            if (success) {
                System.out.printf("$%.2f has been processed for withdrawal from the %s account of %s.%n",
                        amount, targetAccount.getAcctType().toString(), selectedEmp.getName());
            } else {
                System.out.printf("Withdrawal of $%.2f from the %s account of %s failed.%n",
                        amount, targetAccount.getAcctType().toString(), selectedEmp.getName());
            }
        }
        // Display updated balance of the specific account
        System.out.printf("Current balance of %s's %s account (ID: %s) after transaction: $%.2f%n",
                selectedEmp.getName(),
                targetAccount.getAcctType().toString(),
                targetAccount.getId(),
                targetAccount.getBalance());
    }
}

