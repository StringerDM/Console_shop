package stream_api_task;

import stream_api_task.comparators.AppComparator;
import stream_api_task.comparators.PriceComparator;
import stream_api_task.common.AppView;
import stream_api_task.common.PageLoop;
import stream_api_task.data_source.CartDataSource;
import stream_api_task.data_source.CatalogDataSource;
import stream_api_task.data_source.OrderDataSource;
import stream_api_task.models.Product;
import stream_api_task.service.ShopService;
import stream_api_task.view.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CartDataSource cartDataSource = new CartDataSource();
        CatalogDataSource catalogDataSource = new CatalogDataSource();
        OrderDataSource orderDataSource = new OrderDataSource();
        ShopService service = new ShopService(cartDataSource, catalogDataSource, orderDataSource);

        AppView addToCartView = new AddToCartView(service);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        ArrayList<AppComparator<Product>> comparators = new ArrayList<>();
        comparators.add(new AppComparator<>(new PriceComparator(), "по возрастанию цены"));
        comparators.add(new AppComparator<>(new PriceComparator(false), "по убыванию цены"));
        AppView catalogView = new CatalogView(catalogChildren, service, comparators);

        AppView cartView = new CartView(service);
        AppView orderView = new OrderView(service);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        AppView mainView = new MainView(mainChildren);

        PageLoop pageLoop = new PageLoop(mainView);
        pageLoop.run();
    }
}
