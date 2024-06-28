package gokhancomert.Model;

import java.time.LocalDate;

public class Customer {

    private Long id;
    private String name;
    private String surname;
    private String address;
    private LocalDate createDate;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Customer(Long id, String name, String surname, String address, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.createDate = createDate;
    }
}
