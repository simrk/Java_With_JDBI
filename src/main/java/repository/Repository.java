package repository;


import model.dto.Artist;
import model.dto.Order;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.TransactionStatus;
import org.skife.jdbi.v2.exceptions.CallbackFailedException;
import org.skife.jdbi.v2.sqlobject.mixins.GetHandle;
import org.skife.jdbi.v2.tweak.HandleCallback;
import org.skife.jdbi.v2.tweak.TransactionHandler;

import java.util.List;

public class Repository
{
  public static final String DB_NAME = "order.db";
  public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/simranjit.kaur/work/javajdbi/" + DB_NAME;

  private OrderDao orderDao = null;
  private ArtistDao artistDao = null;
  private DBI dbi = null;


  public void init()
  {
    dbi = new DBI(CONNECTION_STRING);
    orderDao = dbi.onDemand(OrderDao.class);
    artistDao = dbi.onDemand(ArtistDao.class);
    TransactionHandler transactionHandler = dbi.getTransactionHandler();
    System.out.println(transactionHandler);
  }

  public List<Order> findAllOrders()
  {
    return orderDao.getAllOrders();
  }

  public Integer addOrder(Order order)
  {
    return orderDao.addOrder(order);
  }

  public List<Order> findOrdersByPrice(int price)
  {
    return orderDao.getOrderByPrice(price);
  }

  public Integer addArtist(Artist artist)
  {
    return artistDao.addArtist(artist);
  }

  public List<Artist> findAllArtists()
  {
    return artistDao.getAllArtists();
  }

  public int InsertBothInSingleShot(Artist artist,Order order)
  {
    int value = dbi.inTransaction((Handle connection, TransactionStatus status)->
    {
      System.out.println("Connection: " + connection);
      System.out.println("Transaction status " + status);
       ArtistDao artistDao = connection.attach(ArtistDao.class);
       OrderDao orderDao = connection.attach(OrderDao.class);
       artistDao.addArtist(artist);
       int rowsEffected = orderDao.addOrder(order);
       return rowsEffected;
    });

    return value;
  }
}
