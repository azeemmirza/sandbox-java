package lab_11_1.prob1;

public class OrderItem {
	private final String productId;

    private final int quantityRequested;

    private final int unitPrice;

    //package level constructor
	OrderItem(String id, int quantity, int price) {
		this.productId = id;
		this.quantityRequested = quantity;
		this.unitPrice = price;
	}

    @Override
	public String toString() {
		return "   " + productId + ": " + quantityRequested + ", " + unitPrice;
	}
}
