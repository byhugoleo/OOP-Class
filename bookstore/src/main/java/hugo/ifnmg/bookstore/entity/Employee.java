package hugo.ifnmg.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity that represents an Employee.
 */
public class Employee extends Person {
// Properties
    List <Loan> loans;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Employee() {
        loans = new ArrayList();
    }

    public Employee(List<Loan> loans, String name, String CPF, String email, String password, String address) {
        super(name, CPF, email, password, address);
        this.loans = loans;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter/Setter">
    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
//</editor-fold>

// Methods
    public void addLoans(Loan loan) {
        this.loans.add(loan);
    }
    
    @Override
    public String toString() {
        return "Employee{"
                + "ID=" + getID()
                + ", name=" + getName()
                + ", CPF=" + getCPF()
                + ", email=" + getEmail()
                + ", password=" + getPassword()
                + ", address=" + getAddress()
                //TODO: Imprimir os empréstismos sem entrar em loop infinito.
                + ", loans=" + loans
                + '}';
    }
}