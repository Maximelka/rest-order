package nc.rest.dao;

import nc.rest.model.Order;
import nc.rest.model.Point;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setName(rs.getString("name"));

        order.setStartPoint(new Point(
                rs.getFloat("start_long"),
                rs.getFloat("start_width")
        ));

        order.setEndPoint(new Point(
                rs.getFloat("end_long"),
                rs.getFloat("end_width")
        ));

        order.setStatus(rs.getString("status"));
        return order;
    }

}
