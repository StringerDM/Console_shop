package stream_api_task.data_source;

import stream_api_task.models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CatalogDataSource {

    public ArrayList<Product> getCatalog() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "SmartPhone", "Best phone", 1000, 5));
        products.add(new Product(2, "Laptop", "Some laptop", 2000, 10));
        products.add(new Product(3, "Watch", "Best watch", 500, 8));
        products.add(new Product(4, "Phone", "Simple phone", 100, 5));
        for (int i = 0; i < 20; i++) {
            products.add(new Product(i + 5, "Phone" + i, "Simple phone", 100 + i * 100, 5 + i / 2));
        }
        return products;
    }

    public ArrayList<Product> getCatalogPage(int page, int limit, Comparator<Product> comparator) {
        ArrayList<Product> products = getCatalog();
        products = products.stream()
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
        ArrayList<Product> products = getCatalog();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
