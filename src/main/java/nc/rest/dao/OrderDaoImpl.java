package nc.rest.dao;

import nc.rest.model.Order;
import nc.rest.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrderDao {
    private static final String SQL_GET_ORDER_BY_ID =
            "select id, name, start_long, start_width, end_long, end_width, status from orders where id = :id";

    private static final String SQL_INSERT_ORDER =
            "insert into orders (name, start_long, start_width, end_long, end_width, status) values (:name, :start_long, :start_width , :end_long , :end_width , :status)";

    private static final String SQL_UPDATE_ORDER =
            "update orders set name = :name, start_long = :start_long, start_width = :start_width, end_long = :end_long, end_width = :end_width, status = :status where id = :id";

    private static final String SQL_DELETE_CAR =
            "delete from orders where id = :id";

    private final OrderMapper orderMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDaoImpl(
            OrderMapper orderMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.orderMapper = orderMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            SQL_GET_ORDER_BY_ID,
                            params,
                            orderMapper
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insertOrder(String name, Point startPoint, Point endPoint, String status) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("start_long", startPoint.getLongitude());
        params.addValue("start_width", startPoint.getWidth());
        params.addValue("end_long", endPoint.getLongitude());
        params.addValue("end_width", endPoint.getWidth());
        params.addValue("status", status);
        jdbcTemplate.update(SQL_INSERT_ORDER, params);
    }

    @Override
    public void updateOrder(String name, Point startPoint, Point endPoint, String status, int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);
        params.addValue("start_long", startPoint.getLongitude());
        params.addValue("start_width", startPoint.getWidth());
        params.addValue("end_long", endPoint.getLongitude());
        params.addValue("end_width", endPoint.getWidth());
        params.addValue("status", status);
        params.addValue("id", id);
        jdbcTemplate.update(SQL_UPDATE_ORDER, params);
    }

    @Override
    public void deleteOrderById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(SQL_DELETE_CAR, params);
    }
}
