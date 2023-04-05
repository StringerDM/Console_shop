package stream_api_task.common;

import stream_api_task.comparators.AppComparator;
import stream_api_task.models.Category;
import stream_api_task.models.Product;

import java.util.ArrayList;

public class AppView {
    private final String title;
    protected Category category;
    private final ArrayList<AppView> children;
    public int nowPage = 0;
    public boolean hasNextPage = false;
    public final ArrayList<AppComparator<Product>> availableComparators = new ArrayList<>();
    public AppComparator<Product> selectedComparator;

    public AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }

    public void action() {}

    public ArrayList<AppView> getChildren() {
        return children;
    }

    public String getTitle() {
        return title;
    }
}
