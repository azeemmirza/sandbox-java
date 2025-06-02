package Laboratory04.Problem43_47;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import Laboratory04.Problem43_47.employeeinfo.*;

/**
 * For Program 4-7 Employee class adjustment.
 */
public class Employee_47 implements Comparable<Employee> {
    private AccountList accounts;
    private String name;
    private LocalDate hireDate;

    public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
        this.name = name;
        this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
        this.accounts = new AccountList();
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void createNewChecking(double startAmount) {
        Account checking = new CheckingAccount(startAmount);
        accounts.add(checking);
        System.out.printf("New Checking Account created for %s with ID %s and initial balance $%.2f%n", name, checking.getId(), startAmount);
    }

    public void createNewSavings(double startAmount) {
        Account savings = new SavingsAccount(startAmount);
        accounts.add(savings);
        System.out.printf("New Savings Account created for %s with ID %s and initial balance $%.2f%n", name, savings.getId(), startAmount);
    }

    public void createNewRetirement(double startAmount) {
        Account retirement = new RetirementAccount(startAmount);
        accounts.add(retirement);
        System.out.printf("New Retirement Account created for %s with ID %s and initial balance $%.2f%n", name, retirement.getId(), startAmount);
    }

    public void deposit(int accountIndex, double amt) {
        if (accountIndex < 0 || accountIndex >= accounts.size()) {
            System.out.println("Error: Invalid account index for deposit.");
            return;
        }
        if (amt <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return;
        }
        Account selectedAccount = accounts.get(accountIndex);
        System.out.printf("Attempting deposit of $%.2f into %s's %s account (ID: %s)...%n",
                amt, name, selectedAccount.getAcctType().toString(), selectedAccount.getId());
        selectedAccount.makeDeposit(amt);
    }

    public boolean withdraw(int accountIndex, double amt) {
        if (accountIndex < 0 || accountIndex >= accounts.size()) {
            System.out.println("Error: Invalid account index for withdrawal.");
            return false;
        }
        if (amt <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }
        Account selectedAccount = accounts.get(accountIndex);
        System.out.printf("Attempting withdrawal of $%.2f from %s's %s account (ID: %s)...%n",
                amt, name, selectedAccount.getAcctType().toString(), selectedAccount.getId());
        return selectedAccount.makeWithdrawal(amt);
    }

    public MyStringList getNamesOfAccounts() {
        MyStringList accountNames = new MyStringList();
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            accountNames.add(acc.getAcctType().toString() + " (ID: " + acc.getId() + ")");
        }
        return accountNames;
    }

    public Account getAccount(int accountIndex) {
        if (accountIndex < 0 || accountIndex >= accounts.size()) {
            return null;
        }
        return accounts.get(accountIndex);
    }

    public String getFormattedAcctInfo() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        sb.append("Employee: ").append(name).append("\n");
        sb.append("Hire Date: ").append(hireDate.format(dateFormatter)).append("\n");
        sb.append("Accounts:\n");

        if (accounts.isEmpty()) {
            sb.append("  No accounts on file.\n");
        } else {
            for (int i = 0; i < accounts.size(); i++) {
                Account acc = accounts.get(i);
                // Calling getBalance() here will trigger its side effects (charges/interest)
                sb.append(String.format(Locale.US, "  %d: %s [%s] - Balance: $%.2f%n",
                        i,
                        acc.getAcctType().toString(),
                        acc.getId(),
                        acc.getBalance()));
            }
        }
        sb.append("----------------------------------------\n");
        return sb.toString();
    }

    /**
     * Calculates the largest balance among all of the employee's accounts.
     * Calling getBalance() on Checking or Savings accounts will trigger their
     * "on read" side effects (charges/interest applied, balance updated).
     * @return The largest balance found. Returns Double.NEGATIVE_INFINITY if no accounts.
     */
    public double getLargestAccountBalance() {
        if (accounts.isEmpty()) {
            return Double.NEGATIVE_INFINITY; // Or 0, or throw exception, depending on desired handling
        }
        double maxBalance = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            double currentBalance = acc.getBalance(); // This call triggers side effects for Checking/Savings
            if (currentBalance > maxBalance) {
                maxBalance = currentBalance;
            }
        }
        return maxBalance;
    }

    /**
     * Compares this employee with another employee based on their largest account balances.
     * @param other The other employee to compare against.
     * @return -1 if this employee's largest balance is less than other's,
     * 1 if this employee's largest balance is greater than other's,
     * 0 if they are equal.
     */
    @Override
    public int compareTo(Employee other) {
        if (other == null) {
            return 1; // Or throw NullPointerException, standard is to throw.
        }
        double thisLargestBalance = this.getLargestAccountBalance();
        double otherLargestBalance = other.getLargestAccountBalance();

        // Debugging output to see what values are being compared:
        // System.out.printf("Comparing %s (%.2f) with %s (%.2f)%n",
        //    this.name, thisLargestBalance, other.name, otherLargestBalance);

        if (thisLargestBalance < otherLargestBalance) {
            return -1;
        } else if (thisLargestBalance > otherLargestBalance) {
            return 1;
        } else {
            // Optional: secondary sort criterion if largest balances are equal (e.g., by name)
            // For this lab, 0 if equal is sufficient.
            return 0;
        }
    }

    /**
     * Returns a string representation of the Employee, showing name and largest account balance.
     * Format: "Name : MaxBalanceValue" (e.g., "Jim Daley : 10095.0")
     * @return The string representation.
     */
    @Override
    public String toString() {
        // Using Locale.US to ensure '.' as decimal separator
        return String.format(Locale.US, "%s : %.1f", this.name, this.getLargestAccountBalance());
    }
}

