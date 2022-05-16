package hugo.ifnmg.database.tests;

import hugo.ifnmg.database.tests.util.Util;
import java.time.LocalDate;

/**
 * Entity that represents a Natural Person.
 * 
 * @author byhugoleo
 */
public final class NaturalPerson extends Entity {
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
        setCPF(CPF);
        setName(name);
        setEmail(email);
        this.birth = birth;
        this.active = active;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) throws IllegalArgumentException {
        if (Util.isValidCPF(CPF)) {
            CPF = CPF.replaceAll("[.-]", "");
            this.CPF = CPF;
        } else
            throw new IllegalArgumentException(">> Invalid CPF.");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws IllegalArgumentException {
        if (name.length() > 50)
            throw new IllegalArgumentException(">> Invalid name size.");
        if (Util.isValidName(name))
            this.name = name;
        else
            throw new IllegalArgumentException(">> Invalid name.");
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws IllegalArgumentException {
        if (Util.isValidEmail(email))
            this.email = email;
        else
            throw new IllegalArgumentException(">> Invalid email.");
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
