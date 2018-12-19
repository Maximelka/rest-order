package nc.rest.service;

import nc.rest.model.Order;
import nc.rest.model.Point;

public interface OrderService {

    Order getOrder(int orderId);

    void createOrder(String name, Point startPoint, Point endPoint, String status);

    void updateOrder(String name, Point startPoint, Point endPoint, String status, int id);

    void deleteOrder(int id);

}
