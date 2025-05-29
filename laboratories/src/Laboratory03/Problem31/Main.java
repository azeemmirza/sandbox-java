package Laboratory03.Problem31;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Helena Mbeua", "Pedro", 50000, 2028, 5, 28);

        Account checking = new Account(emp, AccountType.CHECKING, 300);
        Account savings = new Account(emp, AccountType.SAVINGS, 300);
        Account retirement = new Account(emp, AccountType.RETIREMENT, 300);

        System.out.println(checking);
        System.out.println(savings);
        System.out.println(retirement);
    }
}
