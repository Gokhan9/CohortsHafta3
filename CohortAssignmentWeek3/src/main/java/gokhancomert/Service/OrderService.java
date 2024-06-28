package gokhancomert.Service;

import gokhancomert.Model.Company;
import gokhancomert.Model.Customer;
import gokhancomert.Model.Order;
import gokhancomert.Model.Product;
import gokhancomert.Repository.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderService {

    private OrderRepository orderRepository = OrderRepository.getOrderRepository();
    private BillService billService = BillService.getBillService();

    private static OrderService orderService = new OrderService();
    private OrderService(){

    }
    public static OrderService getOrderService(){
        return orderService;
    }

    public Order save(LocalDate createDate, Long id, Customer customer, List<Product> productList, Company company){
        BigDecimal totalAmount = productList.stream().map(it->it.getTotalAmount()).reduce(BigDecimal.ZERO,BigDecimal::add);
        Order order = new Order(createDate, id, totalAmount, customer, productList);
        orderRepository.save(order);
        billService.save(customer,totalAmount,order,createDate, company); //DÜZENLENİCEKKKKK!!!!!!!!!!!!!!!!!!!!
        return order;

    }


}
