package lab_05.prob4.extpackage;

import java.time.LocalDate;

import lab_05.prob4.CustOrderFactory;
import lab_05.prob4.Customer;
import lab_05.prob4.Order;

public class Main {
    public static void main(String[] args) {
        Customer customer = CustOrderFactory.createCustomer("Bob");

        Order order = CustOrderFactory.createOrder(customer, LocalDate.now());

        order.addItem("Juice");
        order.addItem("Mobile");

        order = CustOrderFactory.createOrder(customer, LocalDate.now());

        order.addItem("Knife");
        order.addItem("Tea Set");

        System.out.println(customer.getOrders());
    }
}

		
