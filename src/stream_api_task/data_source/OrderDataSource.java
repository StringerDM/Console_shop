package stream_api_task.data_source;

import stream_api_task.models.Order;

public class OrderDataSource {
    private Order order;

    public void createOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
