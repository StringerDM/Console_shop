package stream_api_task.models;

import java.util.ArrayList;

public class Order {

    String name;
    String phone;
    String address;
    String paymentType;
    String deliveryTime;
    ArrayList<CartItem> cart;

    public Order(String name, String phone, String address, String paymentType, String deliveryTime, ArrayList<CartItem> cart) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.paymentType = paymentType;
        this.deliveryTime = deliveryTime;
        this.cart = cart;
    }
}
