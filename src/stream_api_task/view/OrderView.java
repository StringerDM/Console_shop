package stream_api_task.view;

import stream_api_task.common.AppView;
import stream_api_task.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderView extends AppView {
    final ShopService service;

    public OrderView(ShopService service) {
        super("Оформление заказа", new ArrayList<>());
        this.service = service;
    }

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя ");
        String name = in.nextLine();
        System.out.println("Введите телефон");
        String phone = in.nextLine();
        service.createOrder(name, phone, "address", "cash", "день");
        System.out.println("Заказ оформлен");
    }
}
