package service;

public class OrderNotFound extends Exception{

    public OrderNotFound() {
        super("The specified order does not exist");
    }
}
