package Laboratory04.Problem43.employeeinfo;

/**
 * Base class for different types of bank accounts.
 * It handles basic functionalities like ID generation, balance management,
 * deposits, and withdrawals.
 *
 * Per requirement (6): "Provide the standard behavior for these
 * functions (reading balance just returns the balance; making withdrawal just
 * deducts the amount from the balance) in the Account superclass."
 */
public abstract class Account { // Made abstract as getAcctType is abstract conceptually
    private static final int ID_LOWER = 1000;
    private static final int ID_UPPER = 9999;

    private String id;
    protected double balance; // Accessible by subclasses

    /**
     * Constructs an Account with a given initial balance.
     * @param initialBalance The starting balance for the account. Cannot be negative.
     */
    public Account(double initialBalance) {
        this.id = generateId();
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting to 0 for account " + this.id);
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    /**
     * Deposits a specified amount into the account.
     * Amount must be positive.
     * @param amount The amount to deposit.
     */
    public void makeDeposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Account [%s]: Deposit of $%.2f successful. New balance: $%.2f%n", id, amount, balance);
        } else {
            System.out.printf("Account [%s]: Deposit amount $%.2f must be positive. Deposit failed.%n", id, amount);
        }
    }

    /**
     * Withdraws a specified amount from the account.
     * Amount must be positive and not exceed the current balance.
     * This method provides standard withdrawal behavior. Subclasses may override for penalties etc.
     * @param amount The amount to withdraw.
     * @return true if withdrawal was successful, false otherwise.
     */
    public boolean makeWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.printf("Account [%s]: Withdrawal amount $%.2f must be positive. Withdrawal failed.%n", id, amount);
            return false;
        }
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Account [%s]: Withdrawal of $%.2f successful. New balance: $%.2f%n", id, amount, balance);
            return true;
        } else {
            System.out.printf("Account [%s]: Insufficient funds for withdrawal of $%.2f. Current balance: $%.2f. Withdrawal failed.%n", id, amount, balance);
            return false;
        }
    }

    /**
     * Gets the current balance of the account.
     * As per requirement (6), this base method just returns the balance.
     * Subclasses (Checking, Savings) will override this to apply charges/interest
     * and update the balance.
     * @return The current balance.
     */
    public double getBalance() {
        // This base version simply returns the current balance without modifying it.
        // Subclasses will override to implement "on read" logic.
        return balance;
    }

    /**
     * Gets the account ID.
     * @return The account ID string.
     */
    public String getId() {
        return id;
    }

    /**
     * Generates a random 4-digit ID for the account.
     * @return A string representing the account ID.
     */
    private String generateId() {
        return "" + RandomNumbers.getRandomInt(ID_LOWER, ID_UPPER);
    }

    /**
     * Returns the type of the account. This method MUST be
     * overridden by concrete subclasses.
     * @return The specific AccountType of the subclass.
     */
    public abstract AccountType getAcctType(); // Made abstract

    /**
     * Provides a string representation of the account (ID and raw balance).
     * Uses the raw balance field to avoid triggering potential side effects
     * from getBalance() in subclasses during string conversion for general display.
     * @return A string in the format "AccountType [id]: $balance".
     */
    @Override
    public String toString() {
        // If getAcctType() could be null for some abstract state, handle it.
        // But since concrete accounts will implement it, it should be safe.
        String typeStr = (getAcctType() != null) ? getAcctType().toString() : "Generic Account";
        return String.format("%s [%s]: $%.2f", typeStr, id, balance);
    }
}

