package Laboratory04.Problem43_47.employeeinfo;

/**
 * Represents a Checking Account.
 * Requirement: "when balance is read for checking account, a $5 monthly service charge
 * will be subtracted"
 */
public class CheckingAccount extends Account {
    private static final double MONTHLY_SERVICE_CHARGE = 5.00;

    /**
     * Constructs a CheckingAccount with a given initial balance.
     * @param initialBalance The starting balance for the account.
     */
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    /**
     * Gets the balance of the checking account.
     * A $5 monthly service charge is subtracted from the balance *each time it's read*.
     * The stored balance is updated accordingly.
     * @return The balance after applying the service charge.
     */
    @Override
    public double getBalance() {
        System.out.printf("Checking Account [%s]: Balance before service charge: $%.2f.%n", getId(), super.balance);
        super.balance -= MONTHLY_SERVICE_CHARGE; // Subtract charge from the actual balance
        System.out.printf("Applied $%.2f service charge. New balance for Checking Account [%s]: $%.2f.%n", MONTHLY_SERVICE_CHARGE, getId(), super.balance);
        return super.balance; // Return the updated balance
    }

    /**
     * Gets the account type.
     * @return AccountType.CHECKING
     */
    @Override
    public AccountType getAcctType() {
        return AccountType.CHECKING;
    }

    // makeDeposit and makeWithdrawal are inherited from Account.
    // No special override needed unless checking accounts have different rules for these operations
    // beyond what's handled in getBalance or the base Account class.
    // For this lab, the specific logic is tied to getBalance (for charges)
    // and the base makeWithdrawal is standard.

    /**
     * Provides a string representation of the checking account.
     * Uses the `balance` field directly to avoid triggering `getBalance()` side effects here.
     * @return A string describing the checking account.
     */
    @Override
    public String toString() {
        // super.toString() would call this class's getAcctType(), which is fine.
        // It uses the raw 'balance' field for display.
        return String.format("%s [%s]: $%.2f (Checking)", getAcctType().toString(), getId(), balance);
        // Or, if we want to use the superclass's toString() formatting:
        // return super.toString();
        // Let's be explicit for clarity, matching the format of Account.toString() but specifying type
    }
}

