package stream_api_task.models;

public class CartItem {
    Product product;
    int count;

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }
}
