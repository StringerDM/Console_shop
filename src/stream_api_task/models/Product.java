package stream_api_task.models;

public class Product {
    private final int id;
    private final String title;
    private final String description;
    private final Category category;
    private final int price;
    private final int qty;

    public Product(int id, Category category, String title, String description, int price, int qty) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public Category getCategory() {
        return category;
    }
}

