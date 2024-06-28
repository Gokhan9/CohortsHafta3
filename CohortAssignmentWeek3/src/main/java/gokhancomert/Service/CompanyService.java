package gokhancomert.Service;

import gokhancomert.Model.Company;
import gokhancomert.Repository.CompanyRepository;

import java.math.BigDecimal;
import java.util.List;

public class CompanyService {

    private CompanyRepository companyRepository = CompanyRepository.getCompanyRepository();
    private BillService billService = BillService.getBillService();

    private static CompanyService companyService = new CompanyService();
    private CompanyService(){

    }

    public static CompanyService getCompanyService(){
        return companyService;
    }

    public Company save(String name, Long id, String sector){
        Company company = new Company(name, sector, id);
        return companyRepository.save(company);
    }

    public List<String > getSectorName(){
        return companyRepository.companyList().stream()
                .filter(it-> billService.billListAverageBySector(it.getSector()).compareTo(BigDecimal.valueOf(0))>0)
                .map(Company::getSector).toList();
    }



}
