package gokhancomert.Repository;

import gokhancomert.Model.Company;
import gokhancomert.Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private List<Company> companyList = new ArrayList<>();

    private static final CompanyRepository customerRepository =  new CompanyRepository();
    private CompanyRepository(){

    }
    public static CompanyRepository getCompanyRepository(){
        return customerRepository;

    }

    public Company save(Company company){
        companyList.add(company);
        return company;
    }

    public List<Company> companyList(){
        return companyList;
    }
}
