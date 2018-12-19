package nc.rest.service;

import nc.rest.dao.OrderDao;
import nc.rest.exception.OrderNotFoundException;
import nc.rest.model.Order;
import nc.rest.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order getOrder(int orderId) {
        return orderDao.getOrderById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @Override
    public void createOrder(String name, Point startPoint, Point endPoint, String status) {
        orderDao.insertOrder(name, startPoint, endPoint, status);
    }

    @Override
    public void updateOrder(String name, Point startPoint, Point endPoint, String status, int id) {
        Order order = orderDao.getOrderById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        orderDao.updateOrder(name, startPoint, endPoint, status,  order.getId());
    }

    @Override
    public void deleteOrder(int id) {
        Order order = orderDao.getOrderById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        orderDao.deleteOrderById(order.getId());
    }
}
