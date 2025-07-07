package Assignment4.prob4C;

import java.util.*;

public class Commissioned extends Employee {
    private double baseSalary;
    private double commission;
    private List<Order> orders;

    public Commissioned(String empId, double baseSalary, double commission) {
        this.empId = empId;
        this.baseSalary = baseSalary;
        this.commission = commission;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    protected double calcGrossPay(int month, int year) {
        double totalOrderAmount = 0;
        for (Order o : orders) {
            if (o.getOrderDate().getMonthValue() == month && o.getOrderDate().getYear() == year) {
                totalOrderAmount += o.getOrderAmount();
            }
        }
        return baseSalary + (commission * totalOrderAmount);
    }

    @Override
    public void print() {

    }
}

