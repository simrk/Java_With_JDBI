package repository;

import model.dto.Order;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements ResultSetMapper<Order>
{

    @Override
    public Order map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Order(
                resultSet.getInt("id"),
                resultSet.getString("order_name"),
                resultSet.getInt("price"),
                resultSet.getInt("quantity"),
                resultSet.getDate("purchase_date")
        );
    }
}
