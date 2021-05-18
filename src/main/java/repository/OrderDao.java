package repository;

import model.dto.Order;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(value=OrderMapper.class)
public interface OrderDao
{
    @SqlQuery("Select * from orders")
    public List<Order> getAllOrders();

    @SqlUpdate("insert into orders(order_name,price,quantity,purchase_date) values(:orderName,:price,:quantity,:purchaseDate)")
    @GetGeneratedKeys
    public Integer addOrder(@BindBean Order order);

    @SqlQuery("Select * from orders where price= :price")
    public List<Order> getOrderByPrice(@Bind("price") int price);
}
