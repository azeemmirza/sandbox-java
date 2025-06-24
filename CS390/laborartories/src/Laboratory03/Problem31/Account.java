package Laboratory03.Problem31;

public class Account {
    private static final double DEFAULT_BALANCE = 0.0;
    private double balance;
    private AccountType accType;
    private Employee employee;
    public Account (Employee emp, AccountType accType, double balance) {
        this.employee = emp;
        this.accType = accType;
        this.balance = balance;
    }

    public Account (Employee emp, AccountType accType) {

        this(emp, accType, DEFAULT_BALANCE);
    }
    public void makeDeposit(double val) {
        if (val > 0) {
            balance += val;
        }
    }

    public boolean makeWithdrawal(double amount) {
        // Assuming that you cannot withdraw money that you don't have
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccType() {
        return accType;
    }

    @Override
    public String toString() {
        return  "Account Type = " + accType + ", Balance = $" + balance;
    }
}
