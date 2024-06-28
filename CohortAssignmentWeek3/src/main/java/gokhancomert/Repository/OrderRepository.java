package gokhancomert.Repository;

import gokhancomert.Model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orderList = new ArrayList<>();

    private static OrderRepository orderRepository = new OrderRepository();
    private OrderRepository(){

    }
    public static OrderRepository getOrderRepository(){
        return orderRepository;
    }

    public Order save(Order order){
        orderList.add(order);
        return order;
    }

    public List<Order> orderList(){
        return orderList;
    }

}
