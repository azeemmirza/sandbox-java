package Assignment5.prob4;

import java.time.LocalDate;

public class CustOrderFactory {
    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public static Order createOrder(Customer cust, LocalDate date) {
        return Order.newOrder(cust, date);
    }

}
