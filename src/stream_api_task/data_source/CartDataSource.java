package stream_api_task.data_source;

import stream_api_task.models.CartItem;
import stream_api_task.models.Product;

import java.util.ArrayList;

public class CartDataSource {

    private ArrayList<CartItem> cart = new ArrayList<>();

    public void addToCart(Product product, int qty) {
        cart.add(new CartItem(product, qty));
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }


}
