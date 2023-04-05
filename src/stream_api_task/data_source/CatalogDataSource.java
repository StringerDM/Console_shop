package stream_api_task.data_source;

import stream_api_task.models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CatalogDataSource {

    ArrayList<Product> catalog = getCatalog();

    public ArrayList<Product> getCatalog() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "phone", "SmartPhone", "Best phone", 1000, 5));
        products.add(new Product(2, "laptop", "Laptop", "Some laptop", 2000, 10));
        products.add(new Product(3, "watch", "Watch", "Best watch", 500, 8));
        products.add(new Product(4, "phone", "Phone", "Simple phone", 100, 5));
        for (int i = 0; i < 20; i++) {
            products.add(new Product(i + 5, "phone", "Phone" + i, "Simple phone", 100 + i * 100, 5 + i / 2));
            products.add(new Product(i + 25, "laptop", "Laptop", "Some laptop", 2000 + i * 10, i));
            products.add(new Product(i + 45, "watch", "Watch", "Some watch", 200 + i * 10, i));
        }
        return products;
    }

    public ArrayList<Product> getCatalogPage(int page, int limit, Comparator<Product> comparator) {
        ArrayList<Product> products;
        products = catalog.stream()
                .filter(p -> p.getQty() > 0)
                .sorted(comparator)
                .skip((long) page * limit)
                .limit(limit)
                .collect(Collectors.toCollection(ArrayList::new));
        return products;
    }

    public ArrayList<Product> getCatalogPage(int page, int limit) {
        return getCatalogPage(page, limit, Comparator.comparing(p -> 0));
    }

    public Product getById(int id) {
        for (Product product : catalog) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
