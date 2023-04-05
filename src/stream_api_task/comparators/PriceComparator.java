package stream_api_task.comparators;

import stream_api_task.models.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    public boolean isAsc = true;

    public PriceComparator() {
    }

    public PriceComparator(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public int compare(Product p1, Product p2) {
        if (isAsc) {
            return p1.getPrice() - p2.getPrice();
        } else {
            return p2.getPrice() - p1.getPrice();
        }
    }
}
