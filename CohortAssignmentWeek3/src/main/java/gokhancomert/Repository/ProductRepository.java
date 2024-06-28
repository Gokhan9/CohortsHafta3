package gokhancomert.Repository;

import gokhancomert.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> productList = new ArrayList<>();

    private static ProductRepository productRepository = new ProductRepository();
    private ProductRepository(){

    }
    public static ProductRepository getProductRepository(){

        return productRepository;
    }

    public Product save(Product product){
        productList.add(product);
        return product;
    }

    public List<Product> productList(){
        return productList;
    }

    public List<Product> getAll() {
        return productList;
    }
}
