package model.dto;

import java.util.Date;


public class Order
{
    private int id;
    private String orderName;
    private int price;
    private int quantity;
    private Date purchaseDate;

    public Order(int id, String orderName, int price, int quantity, Date purchaseDate) {
        this.id = id;
        this.orderName = orderName;
        this.price = price;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }
    public Order(String orderName, int price, int quantity, Date purchaseDate)
    {
        this.orderName = orderName;
        this.price = price;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }

    public int getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

}
