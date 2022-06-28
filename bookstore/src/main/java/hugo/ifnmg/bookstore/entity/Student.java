package hugo.ifnmg.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity that represents a Student.
 */
public final class Student extends Person {
// Properties
    private String enrollment;
    List <Loan> loans;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Student() {
        super();
        loans = new ArrayList();
    }
    
    public Student(List<Loan> loans, String name, String CPF, String email, String password, String adress) {
        super(name, CPF, email, password, adress);
        this.loans = loans;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

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
        return "Student{"
                + "ID=" + getID()
                + ", name=" + getName()
                + ", CPF=" + getCPF()
                + ", email=" + getEmail()
                + ", password=" + getPassword()
                + ", address=" + getAddress()
                + ", enrollment=" + enrollment 
                + ", loans=" + loans
                + '}';
    }
}