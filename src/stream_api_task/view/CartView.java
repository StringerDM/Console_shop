package stream_api_task.view;

import stream_api_task.common.AppView;
import stream_api_task.models.CartItem;
import stream_api_task.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    final ShopService service;
    public String format = "%-4s%-14s%-2s\n";

    public CartView(ShopService service) {
        super("Корзина", new ArrayList<>());
        this.service = service;
    }

    @Override
    public void action() {
        ArrayList<CartItem> cart =  service.getCart();
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.printf(format, "ID", "Description", "Quantity");
            for (CartItem cartItem : cart) {
                System.out.printf(format, cartItem.getProduct().getId(), cartItem.getProduct().getTitle(), cartItem.getCount());
            }
        }
        System.out.println();
    }
}
