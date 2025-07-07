package Assignment4.prob4E;

public abstract class Account {
    protected String accountId;
    protected double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public abstract double computeUpdatedBalance();

}
