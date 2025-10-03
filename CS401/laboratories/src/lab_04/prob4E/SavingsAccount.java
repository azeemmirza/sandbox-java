package lab_04.prob4E;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountId, double interestRate, double balance) {
        super(accountId, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double computeUpdatedBalance() {
        return balance + (balance * interestRate);
    }
}
