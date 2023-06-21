package service;

import models.Order;

import java.util.ArrayList;

public interface OrderService {
    Order getOrderById(int id) throws OrderNotFound;

    ArrayList<Order> getAllOrders();

    Order addOrder(Order order);
}
