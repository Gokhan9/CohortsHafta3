package gokhancomert.Service;

import gokhancomert.Model.Bill;
import gokhancomert.Model.Company;
import gokhancomert.Model.Customer;
import gokhancomert.Model.Order;
import gokhancomert.Repository.BillRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BillService {

    private BillRepository billRepository = BillRepository.getBillRepository();

    private static BillService billService = new BillService();
    private BillService(){

    }
    public static BillService getBillService(){
        return billService;
    }

    public Bill save(Customer customer, BigDecimal totalAmount, Order order, LocalDate createDate, Company company){
        Bill bill = new Bill(customer, createDate, totalAmount, order, company);
        return billRepository.save(bill);
    }

    public List<Bill> billList(){
        return billRepository.billList();
    }

    public BigDecimal billListByMonth(Month month){
        return billRepository.billList().stream().filter(it -> it.getCustomer().getCreateDate().getMonth().equals(month)).
                map(Bill::getTotalAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public List<Bill> billListUpperAmount(BigDecimal amount){
        return billRepository.billList().stream().filter(it -> it.getTotalAmount().compareTo(BigDecimal.valueOf(1500)) > 0).toList();
    }

    //OrtalamaHesabı
    public BigDecimal billListAverageAmount(BigDecimal amount){
        List<Bill> billList = billRepository.billList().stream()
                .filter(it -> it.getTotalAmount()
                        .compareTo(amount) > 0).toList();
        BigDecimal totalAmount = billList.stream().map(Bill::getTotalAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
        return totalAmount.divide(BigDecimal.valueOf(billList.size()));
    }

    public BigDecimal billListAverageBySector(String sector){
        List<Bill> billList = billRepository.billList().stream()
                .filter(it -> it.getCreateDate().getMonth().equals(Month.JUNE))
                .filter(it -> it.getCompany().getSector().equals(sector)).toList();
        BigDecimal totalAmount = billList.stream().map(Bill::getTotalAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
        if (!billList.isEmpty()) {
            return totalAmount.divide(BigDecimal.valueOf(billList.size()));
        }
        else {
            return BigDecimal.valueOf(0);
        }

    }

}
