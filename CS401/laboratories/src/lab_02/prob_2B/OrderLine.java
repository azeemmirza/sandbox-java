package lab_02.prob_2B;

public class OrderLine {
    private Order order;

    public OrderLine(Order order) {
        this.order = order;
        order.addOrderLine(this);
    }
}