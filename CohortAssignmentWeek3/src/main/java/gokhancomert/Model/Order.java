package gokhancomert.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {

    private LocalDate createDate;
    private Long id;
    private BigDecimal totalAmount;
    private Customer customer;
    private List<Product> productList;

    public Order(LocalDate createDate, Long id, BigDecimal totalAmount, Customer customer, List<Product> productList) {
        this.createDate = createDate;
        this.id = id;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.productList = productList;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProduct() {
        return productList;
    }

    public void setProduct(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "createDate=" + createDate +
                ", id=" + id +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                ", product=" + productList +
                '}';
    }
}
