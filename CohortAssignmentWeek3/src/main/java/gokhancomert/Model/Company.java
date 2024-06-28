package gokhancomert.Model;

public class Company {

    private String name;
    private Long id;
    private String sector;

    public Company(String name, String sector, Long id) {
        this.name = name;
        this.sector = sector;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sector='" + sector + '\'' +
                '}';
    }
}
