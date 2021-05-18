import model.dto.Artist;
import model.dto.Order;
import repository.Repository;

import java.util.Date;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Repository repository = new Repository();
        repository.init();
//        repository.addOrder(new Order("order1",1,1, new Date()));
//        repository.addOrder(new Order("order2",1,1, new Date()));
//        repository.addOrder(new Order("order3",1,1, new Date()));
        List<Order> orders = repository.findAllOrders();
        for(Order order: orders)
        {
            System.out.println("OrderId: "+ order.getId()+ " OrderName: " + order.getOrderName()+ " Price: "+order.getPrice() +
                    " Quantity: "+ order.getQuantity() + " Date: "+ order.getPurchaseDate());
        }

//        orders = repository.findOrdersByPrice(1);
//        if(orders.isEmpty())
//        {
//            System.out.println("Empty order list");
//            return;
//        }
//        for(Order order: orders)
//        {
//            System.out.println("OrderId: "+ order.getId()+ " OrderName: " + order.getOrderName()+ " Price: "+order.getPrice() +
//                    " Quantity: "+ order.getQuantity() + " Date: "+ order.getPurchaseDate());
//        }

//        repository.addArtist(new Artist("artist1"));
//        repository.addArtist(new Artist("artist2"));
//        repository.addArtist(new Artist("artist3"));
        List<Artist> artists = repository.findAllArtists();
        for(Artist artist: artists)
        {
            System.out.println("ArtistId: "+ artist.getId() + " ArtistName: "+ artist.getName());
        }

       int result = repository.InsertBothInSingleShot(new Artist("artist1"),new Order("order5",1,1, new Date()));
        System.out.println("Row effected: "+ result);
    }


}
