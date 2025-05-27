import Laboratory02.Problem21.Address;
import Laboratory02.Problem21.Customer;

public class Main {
    public static void main(String[] args) {
        Address billingAddr1 = new Address("10 Adams", "Fairfield", "IA", "52556");
        Address shippingAddr1 = new Address("15 Greenlands", "Fairfield", "IA", "52556");

        Address billingAddr2 = new Address("07 Rosie", "Chicago", "IL", "60039");
        Address shippingAddr2 = new Address("07 Rosie", "Chicago", "IL", "60039");

        Customer c1 = new Customer("John", "Doe", "123", billingAddr1, shippingAddr1);
        Customer c2 = new  Customer("Jane", "Smith", "456", billingAddr2, shippingAddr2);

        Customer[] customers = {c1,c2};

        System.out.println("Customers with billing Address in Chicago:");

        for(Customer c : customers){
            if(c.getBillingAddress().getCity().equals("Chicago")){
                System.out.println(c);
            }
        }
    }
}