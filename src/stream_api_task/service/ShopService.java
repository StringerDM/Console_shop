package stream_api_task.service;

import stream_api_task.data_source.CartDataSource;
import stream_api_task.data_source.CatalogDataSource;
import stream_api_task.data_source.OrderDataSource;
import stream_api_task.models.CartItem;
import stream_api_task.models.Category;
import stream_api_task.models.Order;
import stream_api_task.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ShopService {
    final CartDataSource cartDataSource;
    final CatalogDataSource catalogDataSource;
    final OrderDataSource orderDataSource;

    public ShopService(CartDataSource cartDataSource, CatalogDataSource catalogDataSource, OrderDataSource orderDataSource) {
        this.cartDataSource = cartDataSource;
        this.catalogDataSource = catalogDataSource;
        this.orderDataSource = orderDataSource;
    }

    public ArrayList<Product> getCatalog() {
        return catalogDataSource.getCatalog();
    }

    public ArrayList<Product> getCatalogPage(int page, int limit, Comparator<Product> comparator, Category category) {
        return catalogDataSource.getCatalogPage(page, limit, comparator, category);
    }

    public ArrayList<Product> getCatalogPage(int page, int limit) {
        return catalogDataSource.getCatalogPage(page, limit);
    }

    public boolean addToCart(int id, int qty) {
        Product product = catalogDataSource.getById(id);
        cartDataSource.addToCart(product, qty);
        return product != null;
    }

    public ArrayList<CartItem> getCart() {
        return cartDataSource.getCart();
    }

    public void createOrder(String name, String phone, String address, String paymentType, String deliveryTime) {
        ArrayList<CartItem> cart = getCart();
        Order newOrder = new Order(name, phone, address, paymentType, deliveryTime, cart);
        orderDataSource.createOrder(newOrder);
    }
}
