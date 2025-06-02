package Laboratory04.Problem43.employeeinfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Laboratory04.Problem43.AccountList;
import Laboratory04.Problem43.MyStringList;

public class Employee {
    private AccountList accounts; // Using AccountList instead of individual accounts
    private String name;
    private LocalDate hireDate;

    public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
        this.name = name;
        this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
        this.accounts = new AccountList(); // Initialize the AccountList
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * Creates a new checking account for the employee and adds it to their list of accounts.
     * @param startAmount The initial balance for the checking account.
     */
    public void createNewChecking(double startAmount) {
        // Check if a checking account already exists (optional, depends on rules)
        // For simplicity, this version allows multiple accounts of the same type.
        // To restrict, you'd iterate through 'accounts' and check getAcctType().
        Account checking = new CheckingAccount(startAmount);
        accounts.add(checking);
        System.out.printf("New Checking Account created for %s with ID %s and initial balance $%.2f%n", name, checking.getId(), startAmount);
    }

    /**
     * Creates a new savings account for the employee and adds it to their list of accounts.
     * @param startAmount The initial balance for the savings account.
     */
    public void createNewSavings(double startAmount) {
        Account savings = new SavingsAccount(startAmount);
        accounts.add(savings);
        System.out.printf("New Savings Account created for %s with ID %s and initial balance $%.2f%n", name, savings.getId(), startAmount);
    }

    /**
     * Creates a new retirement account for the employee and adds it to their list of accounts.
     * @param startAmount The initial balance for the retirement account.
     */
    public void createNewRetirement(double startAmount) {
        Account retirement = new RetirementAccount(startAmount);
        accounts.add(retirement);
        System.out.printf("New Retirement Account created for %s with ID %s and initial balance $%.2f%n", name, retirement.getId(), startAmount);
    }

    /**
     * Deposits a specified amount into one of the employee's accounts.
     * @param accountIndex The index of the account in the employee's AccountList.
     * @param amt The amount to deposit.
     */
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
        selectedAccount.makeDeposit(amt); // Polymorphic call
    }

    /**
     * Withdraws a specified amount from one of the employee's accounts.
     * @param accountIndex The index of the account in the employee's AccountList.
     * @param amt The amount to withdraw.
     * @return true if withdrawal was successful, false otherwise.
     */
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
        boolean success = selectedAccount.makeWithdrawal(amt); // Polymorphic call
        if (!success) {
            // The makeWithdrawal method in Account and RetirementAccount already prints detailed messages.
            // System.out.println("Withdrawal failed (e.g., insufficient funds or other rule).");
        }
        return success;
    }

    /**
     * Gets a list of account type names for this employee.
     * Example: ["Checking", "Savings"]
     * @return MyStringList containing the names of the account types.
     */
    public MyStringList getNamesOfAccounts() {
        MyStringList accountNames = new MyStringList();
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            // Using AccountType.toString() which is overridden to be user-friendly
            accountNames.add(acc.getAcctType().toString() + " (ID: " + acc.getId() + ")");
        }
        return accountNames;
    }

    /**
     * Gets the account at a specific index. Used by Main to then call getBalance.
     * @param accountIndex the index of the account.
     * @return The Account object or null if index is invalid.
     */
    public Account getAccount(int accountIndex) {
        if (accountIndex < 0 || accountIndex >= accounts.size()) {
            return null;
        }
        return accounts.get(accountIndex);
    }


    /**
     * Generates a formatted string containing all account information for this employee.
     * This method will trigger "on read" effects (charges/interest) for Checking/Savings
     * accounts if it calls their getBalance() methods.
     * For display purposes, it's often better to show the raw balance unless explicitly
     * triggering updates. The Account.toString() method is designed to show raw balance.
     *
     * If the intent of "See a report of all accounts" is to apply charges/interest,
     * then getBalance() should be called here.
     *
     * Let's assume for the report, we want to show the balance *after* any "on-read" effects.
     * @return A formatted string with all account details.
     */
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
                sb.append(String.format("  %d: %s [%s] - Balance: $%.2f%n",
                        i,
                        acc.getAcctType().toString(),
                        acc.getId(),
                        acc.getBalance())); // IMPORTANT: Calling getBalance() here will trigger side effects
                // for Checking and Savings accounts as per requirements.
                // This means the report shows balance *after* charges/interest.
            }
        }
        sb.append("----------------------------------------\n");
        return sb.toString();
    }
}
