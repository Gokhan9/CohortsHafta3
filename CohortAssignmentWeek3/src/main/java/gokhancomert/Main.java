package gokhancomert;

import gokhancomert.Model.Company;
import gokhancomert.Model.Customer;
import gokhancomert.Model.Product;
import gokhancomert.Service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        //Customer
        System.out.println("Customer List\n");
        CustomerService customerService = CustomerService.getCustomerService();

        Customer customer1 = customerService.save(1L, "Caner", "Özköy", "İstanbul", LocalDate.of(2024, 6, 13));
        Customer customer2 = customerService.save(3L, "Cem", "Dırman","İstanbul", LocalDate.of(2024, 12, 23));
        Customer customer3 = customerService.save(5L, "Gökhan","Cömert","Ankara", LocalDate.of(2024, 4, 1));
        Customer customer4 = customerService.save(7L, "Ali","Aydın","İzmir", LocalDate.of(2024, 2, 3));
        customerService.customerList().forEach(System.out::println);

        //Company
        CompanyService companyService = CompanyService.getCompanyService();
        Company company1 = companyService.save("Koton", 1L,"Sector1");
        Company company2 = companyService.save("Nike", 2L,"Sector2");
        Company company3 = companyService.save("Decathlon", 3L,"Sector3");




        //Product
        System.out.println("\nProduct List\n");
        ProductService productService = ProductService.getProductService();

        Product product1 = productService.save(2L, "Sweatshirt", new BigDecimal(250));
        Product product2 = productService.save(4L, "Trousers", new BigDecimal(380));
        Product product3 = productService.save(6L, "Hat", new BigDecimal(95));
        Product product4 = productService.save(8L,"T-shirt", new BigDecimal(175));
        Product product5 = productService.save(10L,"Socks", new BigDecimal(2000));

        productService.listAll();


        //Order
        System.out.println("\nOrder List\n");
        OrderService orderService = OrderService.getOrderService();

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        orderService.save(LocalDate.of(2025, 6, 25), 1L ,customer1, productList, company2);

        List<Product> productList2 = new ArrayList<>();
        productList2.add(product1);
        orderService.save(LocalDate.of(2025, 6, 25), 1L ,customer1, productList2, company3);

        List<Product> productList1 = new ArrayList<>();
        productList1.add(product4);
        productList1.add(product5);
        orderService.save(LocalDate.of(2025, 3, 25), 1L ,customer2, productList1, company1);

        List<Product> productList3 = new ArrayList<>();
        productList3.add(product1);
        productList3.add(product5);
        orderService.save(LocalDate.of(2025, 3, 25), 1L ,customer3, productList3, company1);

        //orderService.getOrderList().forEach(System.out::println);


        //Bill
        BillService billService = BillService.getBillService();
        billService.billList().forEach(System.out::println);

        System.out.println("\n--- OUTPUT --- \n");

        System.out.print("\nnumbers: ");
        System.out.println(customerService.customerList().size());

        System.out.println("-İçerisinde ‘C’ harfi olan müşteriler: ");
        System.out.println(customerService.customerListIncludeC());

        System.out.println("-Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarını listeleyin: ");
        System.out.println(billService.billListByMonth(Month.JUNE));

        System.out.println("-Sistemdeki tüm faturaları listeleyin: ");
        System.out.println(billService.billList());

        System.out.println("-Sistemdeki 1500TL üstündeki faturaları listeleyin: ");
        System.out.println(billService.billListUpperAmount(BigDecimal.valueOf(1500)));

        System.out.println("-Sistemdeki 1500TL üstündeki faturaları ortalamasını hesaplayın: ");
        System.out.println(billService.billListAverageAmount(BigDecimal.valueOf(1500)));

        System.out.println("-Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin: ");
        System.out.println(customerService.customerListLowerAmount());

        System.out.println("-Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeleyen kodu yazın: ");
        System.out.println(companyService.getSectorName());

    }

}