package Laboratory04.Problem43.employeeinfo;

/**
 * Represents a Savings Account.
 * Requirement: "when balance is read for savings, a 0.25% monthly interest rate is applied"
 */
public class SavingsAccount extends Account {
    // The prompt specified "0.25 should be represented as a constant"
    // This could mean 0.25 as the percentage, or 0.0025 as the rate.
    // Let's use the percentage and divide by 100.
    private static final double MONTHLY_INTEREST_PERCENT = 0.25; // 0.25%

    /**
     * Constructs a SavingsAccount with a given initial balance.
     * @param initialBalance The starting balance for the account.
     */
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    /**
     * Gets the balance of the savings account.
     * A 0.25% monthly interest is added to the balance *each time it's read*.
     * The stored balance is updated accordingly.
     * @return The balance after applying interest.
     */
    @Override
    public double getBalance() {
        System.out.printf("Savings Account [%s]: Balance before interest: $%.2f.%n", getId(), super.balance);
        double interestRate = MONTHLY_INTEREST_PERCENT / 100.0; // Convert percent to decimal rate
        double interestEarned = super.balance * interestRate;
        super.balance += interestEarned; // Add interest to the actual balance
        System.out.printf("Applied %.2f%% interest (Amount: $%.2f). New balance for Savings Account [%s]: $%.2f.%n", MONTHLY_INTEREST_PERCENT, interestEarned, getId(), super.balance);
        return super.balance; // Return the updated balance
    }

    /**
     * Gets the account type.
     * @return AccountType.SAVINGS
     */
    @Override
    public AccountType getAcctType() {
        return AccountType.SAVINGS;
    }

    // makeDeposit and makeWithdrawal are inherited from Account.
    // No special override needed for this lab's requirements.

    /**
     * Provides a string representation of the savings account.
     * Uses the `balance` field directly to avoid triggering `getBalance()` side effects here.
     * @return A string describing the savings account.
     */
    @Override
    public String toString() {
        return String.format("%s [%s]: $%.2f (Savings)", getAcctType().toString(), getId(), balance);
    }
}

