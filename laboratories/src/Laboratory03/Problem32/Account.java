package Laboratory03.Problem32;
public class Account {
    private static final int ID_LOWER = 1000;
    private static final int ID_UPPER = 9999;

    private String id;
    private double balance;

    public Account() {
        id = generateId();
    }

    public void updateBalance(double amount) {
        balance += amount;
    }
    public double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    private String generateId() {
        //in actual practice, read from a database or
        //external data source
        return "" + RandomNumbers.getRandomInt(ID_LOWER,ID_UPPER);
    }
    public String toString() {
        return id + ":" + balance;
    }
}
