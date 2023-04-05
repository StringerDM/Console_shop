package stream_api_task.models;

public class Product {
    private int id;
    private String title;
    private String description;
    private int price;
    private int qty;

    public Product(int id, String title, String description, int price, int qty) {
        this.id = id;
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
}

