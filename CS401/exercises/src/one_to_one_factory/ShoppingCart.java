package one_to_one_factory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    private ShoppingCart() {
        this.items = new ArrayList<Item>();
    }

    public static ShoppingCart getInstance(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException();
        }

        ShoppingCart cart = new ShoppingCart();
        customer.setShoppingCart(cart);

        return cart;
    }
}
