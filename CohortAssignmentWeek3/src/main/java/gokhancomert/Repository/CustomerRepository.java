package gokhancomert.Repository;

import gokhancomert.Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    private static final CustomerRepository customerRepository =  new CustomerRepository();
    private CustomerRepository(){

    }
    public static CustomerRepository getCustomerRepository(){
        return customerRepository;

    }

    public Customer save(Customer customer){
        customerList.add(customer);
        return customer;
    }

    public List<Customer> customerList(){
        return customerList;
    }




}
