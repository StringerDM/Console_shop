package stream_api_task.view;

import stream_api_task.comparators.AppComparator;
import stream_api_task.comparators.PriceComparator;
import stream_api_task.common.AppView;
import stream_api_task.common.Paginable;
import stream_api_task.models.Product;
import stream_api_task.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView implements Paginable {
    final ShopService service;
    public String format = "%-4s%-14s%-2s\n";

    public CatalogView(ArrayList<AppView> children, ShopService service, ArrayList<AppComparator<Product>> comparators) {
        super("Каталог", children);
        this.service = service;
        availableComparators.addAll(comparators);
        if (!availableComparators.isEmpty()) {
            selectedComparator = availableComparators.get(0);
        }
    }

    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsc = false;
        ArrayList<Product> catalog =  service.getCatalogPage(nowPage, pageLimit, selectedComparator.comparator);

        hasNextPage = (catalog.size() == pageLimit);

        System.out.printf(format, "ID", "Description", "Price");
        for (Product product : catalog) {
            System.out.printf(format, product.getId(), product.getTitle(), product.getPrice());
        }
        System.out.println();
    }
}
