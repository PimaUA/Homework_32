package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import models.Order;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderRepository implements OrderService{
    private static OrderRepository instance;
    private static ArrayList<Order> ordersList=new ArrayList<>();
    //ArrayList<Order> ordersList;
    static{
        ordersList.add(new Order(1, LocalDate.of(2023, 6, 12), 170));
        ordersList.add(new Order(2, LocalDate.of(2023, 6, 15), 170));
        ordersList.add(new Order(3, LocalDate.of(2023, 6, 14), 170));
    }

    private OrderRepository() {
        //ordersList=new ArrayList<>();
        /*ordersList.add(new Order(1, LocalDate.of(2023, 6, 12), 170));
        ordersList.add(new Order(2, LocalDate.of(2023, 6, 15), 170));
        ordersList.add(new Order(3, LocalDate.of(2023, 6, 14), 170));*/
    }

    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }

    @Override
    public Order getOrderById(int id) throws OrderNotFound {
        for (Order eachOrder : ordersList) {
            if (eachOrder.getId() == id) {
                return eachOrder;
            }
        }
        throw new OrderNotFound();
    }

    @Override
    public ArrayList<Order> getAllOrders() {
        return ordersList;
    }

    @Override
    public Order addOrder(Order order) {
        ordersList.add(order);
        return order;
    }
}
