package hugo.ifnmg.database.tests;

import hugo.ifnmg.database.tests.util.Util;
import java.time.LocalDate;

/**
 * Entity that represents a Natural Person.
 * 
 * @author byhugoleo
 */
public class NaturalPerson extends Entity {
// Properties
    private String CPF;
    private String name;
    private String email;
    private LocalDate birth;
    private Boolean active;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public NaturalPerson() {
    }
    public NaturalPerson(String CPF, String name, String email, LocalDate birth, Boolean active) {
        super(CPF);
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.active = active;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        if (Util.isValidCPF(CPF))
            this.CPF = CPF;
        else
            throw new IllegalArgumentException(">> Invalid CPF.");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() > 50)
            throw new IllegalArgumentException(">> Invalid name size.");
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getBirth() {
        return birth;
    }
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
//</editor-fold>
    
// Methods
    @Override
    public String toString() {
        return "Entity{" + "ID=" + getID() + "} "
                + "NaturalPerson{" + "CPF=" + CPF 
                + ", name=" + name 
                + ", email=" + email 
                + ", birth=" + birth 
                + ", active=" + active + '}';
    }
}
