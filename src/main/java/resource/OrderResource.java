package resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.Order;
import service.OrderNotFound;
import service.OrderRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Path("orders")
public class OrderResource {
    private final OrderRepository orderRepository = OrderRepository.getInstance();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) throws OrderNotFound {
        Order order = orderRepository.getOrderById(id);
        if (order != null) {
            return Response.ok(order, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        ArrayList<Order> listOrders = orderRepository.getAllOrders();
        if (listOrders.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(listOrders).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Order order) throws URISyntaxException {
        int newOrderId = orderRepository.addOrder(order).getId();
        URI uri = new URI("/add/" + newOrderId);
        return Response.created(uri).build();
    }
}
