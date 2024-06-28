package gokhancomert.Repository;

import gokhancomert.Model.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillRepository {

    private List<Bill> billList = new ArrayList<>();

    private static BillRepository billRepository = new BillRepository();
    private BillRepository(){

    }
    public static BillRepository getBillRepository(){
        return billRepository;
    }

    public Bill save(Bill bill){
        billList.add(bill);
        return bill;
    }

    public List<Bill> billList(){
        return billList;
    }


}
