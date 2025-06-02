package Laboratory04.Problem43.employeeinfo;

/**
 * Represents a Retirement Account.
 * Requirement: "when a withdrawal is made from a retirement account, a 2% penalty
 * is applied to the balance" - Interpreted as 2% of the withdrawal amount is the penalty.
 */
public class RetirementAccount extends Account {
    private static final double WITHDRAWAL_PENALTY_PERCENT = 2.0; // 2%

    /**
     * Constructs a RetirementAccount with a given initial balance.
     * @param initialBalance The starting balance for the account.
     */
    public RetirementAccount(double initialBalance) {
        super(initialBalance);
    }

    /**
     * Withdraws a specified amount from the retirement account.
     * A 2% penalty on the withdrawal amount is also deducted from the balance.
     * @param amount The amount the user intends to receive (net withdrawal).
     * @return true if withdrawal was successful (amount + penalty <= balance), false otherwise.
     */
    @Override
    public boolean makeWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.printf("Retirement Account [%s]: Withdrawal amount $%.2f must be positive. Withdrawal failed.%n", getId(), amount);
            return false;
        }

        double penaltyRate = WITHDRAWAL_PENALTY_PERCENT / 100.0;
        double penaltyAmount = amount * penaltyRate;
        double totalDeduction = amount + penaltyAmount;

        System.out.printf("Retirement Account [%s] withdrawal attempt:%n", getId());
        System.out.printf("  Requested withdrawal: $%.2f%n", amount);
        System.out.printf("  Withdrawal penalty (%.1f%% of amount): $%.2f%n", WITHDRAWAL_PENALTY_PERCENT, penaltyAmount);
        System.out.printf("  Total deduction from balance: $%.2f%n", totalDeduction);
        System.out.printf("  Current balance before this withdrawal: $%.2f%n", super.balance);


        if (totalDeduction <= super.balance) {
            super.balance -= totalDeduction;
            System.out.printf("  Withdrawal successful. New balance for Retirement Account [%s]: $%.2f%n", getId(), super.balance);
            return true;
        } else {
            System.out.printf("  Insufficient funds for withdrawal (including penalty). Total needed: $%.2f. Withdrawal failed.%n", totalDeduction);
            return false;
        }
    }

    /**
     * Gets the balance of the retirement account.
     * No special processing (like charges or interest on read) for retirement account
     * when reading balance, so it uses the base class implementation which just returns the balance.
     * @return The current balance.
     */
    // No override for getBalance() is needed if it behaves like the base Account's getBalance().
    // The penalty is applied during makeWithdrawal, not on read.
    // So, super.getBalance() will be called, which just returns 'balance'.

    /**
     * Gets the account type.
     * @return AccountType.RETIREMENT
     */
    @Override
    public AccountType getAcctType() {
        return AccountType.RETIREMENT;
    }

    // makeDeposit is inherited from Account.
    // No special override needed for this lab's requirements.

    /**
     * Provides a string representation of the retirement account.
     * Uses the `balance` field directly to avoid triggering `getBalance()` side effects here.
     * @return A string describing the retirement account.
     */
    @Override
    public String toString() {
        return String.format("%s [%s]: $%.2f (Retirement)", getAcctType().toString(), getId(), balance);
        // return super.toString(); // Alternative
    }
}

