package one_to_one_factory;

public class Customer {
    private String name;
    private ShoppingCart cart;


    public Customer(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public ShoppingCart getShoppingCart() {
        return this.cart;
    }

    public void setShoppingCart(ShoppingCart cart) {
        if (this.cart != null) {
            this.cart = cart;
        }
    }
}
