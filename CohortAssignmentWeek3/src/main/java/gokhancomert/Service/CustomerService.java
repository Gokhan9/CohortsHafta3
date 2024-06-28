package gokhancomert.Service;

import gokhancomert.Model.Customer;

import gokhancomert.Repository.CustomerRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository = CustomerRepository.getCustomerRepository();
    private BillService billService = BillService.getBillService();

    private static CustomerService customerService = new CustomerService();
    private CustomerService(){

    }
    public static CustomerService getCustomerService(){
        return customerService;
    }

    public Customer save(Long id, String name, String surname, String address, LocalDate createDate){
        Customer customer = new Customer(id, name, surname, address, createDate);
        return customerRepository.save(customer);
    }

    public List<Customer> customerList(){
        return customerRepository.customerList();
    }

    public List<Customer> customerListIncludeC(){
        return customerRepository.customerList().stream().filter(it -> it.getName().toLowerCase().contains("c")).toList();
    }

    public List<String> customerListLowerAmount(){
        return billService.billList().stream()
                .filter(it -> it.getTotalAmount()
                        .compareTo(BigDecimal.valueOf(500)) < 0)
                .map(it -> it.getCustomer().getName())
                .toList();
    }






}
