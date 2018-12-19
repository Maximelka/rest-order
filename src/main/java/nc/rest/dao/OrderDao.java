package nc.rest.dao;

import nc.rest.model.Order;
import nc.rest.model.Point;

import java.util.Optional;

public interface OrderDao {

    Optional<Order> getOrderById(int id);

    void insertOrder(String name, Point startPoint, Point endPoint, String status);

    void updateOrder(String name, Point startPoint, Point endPoint, String status, int id);

    void deleteOrderById(int id);

}
