package hugo.ifnmg.bookstore.entity;

/**
 * Entity that represents a Person.
 */
public class Person extends Entity {
// Properties
    private String name;
    private String CPF;
    private String email;
    private String password;
    private String address;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Person() {}
    
    public Person(String name, String CPF, String email, String password, String address) {
        this.name = name;
        this.CPF = CPF;
        this.email = email;
        this.password = password;
        this.address = address;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
//</editor-fold>

// Methods
    @Override
    public String toString() {
        return "Person={"
                + "ID=" + getID()
                + ", name=" + name
                + ", CPF=" + CPF
                + ", email=" + email
                + ", password=" + password
                + ", address=" + address
                + "}";
    }
}