package gokhancomert.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bill {

    private Customer customer;
    private BigDecimal totalAmount;
    private Order order;
    private LocalDate createDate;
    private Company company;

    public Bill(Customer customer, LocalDate createDate, BigDecimal totalAmount, Order order,Company company) {
        this.customer = customer;
        this.createDate = createDate;
        this.totalAmount = totalAmount;
        this.order = order;
        this.company= company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customer=" + customer +
                ", totalAmount=" + totalAmount +
                ", order=" + order +
                ", createDate=" + createDate +
                '}';
    }
}
