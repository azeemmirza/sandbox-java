package lab_02.prob_2B;

import java.util.*;

public class Order {
    private String orderNum;
    private List<OrderLine> lines;

    public Order(String orderNum) {
        this.orderNum = orderNum;
        this.lines = new ArrayList<>();
    }

    public void addOrderLine(OrderLine line) {
        lines.add(line);
    }
}
