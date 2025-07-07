package Assignment5.prob4.extpackage;

import java.time.LocalDate;

import Assignment5.prob4.CustOrderFactory;
import Assignment5.prob4.Customer;
import Assignment5.prob4.Order;

public class Main {
    public static void main(String[] args) {
        Customer customer = CustOrderFactory.createCustomer("Bob");

        Order order = CustOrderFactory.createOrder(customer, LocalDate.now());

        order.addItem("Shirt");
        order.addItem("Laptop");

        order = CustOrderFactory.createOrder(customer, LocalDate.now());

        order.addItem("Pants");
        order.addItem("Knife set");

        System.out.println(customer.getOrders());
    }
}

		
