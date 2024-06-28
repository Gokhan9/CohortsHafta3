package gokhancomert.Service;

import gokhancomert.Model.Product;
import gokhancomert.Repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    private ProductRepository productRepository = ProductRepository.getProductRepository();

    private static ProductService productService = new ProductService();
    private ProductService(){

    }

    public static ProductService getProductService(){
        return productService;
    }

    public Product save(Long productId, String productName, BigDecimal totalAmount){
        Product product = new Product(productId, productName, totalAmount);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    public void listAll(){
        getAllProducts().forEach(System.out::println);
    }
}
