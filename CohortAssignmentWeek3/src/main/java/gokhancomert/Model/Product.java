package gokhancomert.Model;

import java.math.BigDecimal;

public class Product {

    private Long productId;
    private String productName;
    private BigDecimal totalAmount;

    public Product(Long productId, String productName, BigDecimal totalAmount) {
        this.productId = productId;
        this.productName = productName;
        this.totalAmount = totalAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
