package hugo.ifnmg.bookstore.entity;

/**
 * Entity that represents a Publisher.
 */
public final class Publisher extends Entity {
// Properties
    private String name;
    private String address;
    private String phoneNumber;
    private String CNPJ;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Publisher() {}

    public Publisher(String name, String address, String phoneNumber, String CNPJ) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.CNPJ = CNPJ;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
//</editor-fold>

// Methods
    @Override
    public String toString() {
        return "Publisher{"
                + "ID=" + getID()
                + ", name=" + name 
                + ", address=" + address 
                + ", phoneNumber=" + phoneNumber 
                + ", CNPJ=" + CNPJ 
                + '}';
    }
}