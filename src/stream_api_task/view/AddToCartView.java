package stream_api_task.view;

import stream_api_task.common.AppView;
import stream_api_task.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    final ShopService service;

    public AddToCartView(ShopService service) {
        super("Добавить товар", new ArrayList<>());
        this.service = service;
    }

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id продукта");
        int id = in.nextInt();
        System.out.println("Введите количество");
        int qty = in.nextInt();
        boolean res = service.addToCart(id, qty);
        if (res) {
            System.out.println("Товар добавлен");
        } else {
            System.out.println("Не удалось добавить товар");
        }
    }
}
