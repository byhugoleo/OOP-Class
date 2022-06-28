package hugo.ifnmg.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity that represents a CopyOfBook.
 */
public final class CopyOfBook extends Entity {
// Properties
    private String code;
    private Boolean available;
    List<Loan> loans;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public CopyOfBook() {
        loans = new ArrayList();
    }

    public CopyOfBook(String code, Boolean available, List<Loan> loans) {
        this.code = code;
        this.available = available;
        this.loans = loans;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
//</editor-fold>

// Métodos
    public void addLoans(Loan loan) {
        this.loans.add(loan);
    }
    
    @Override
    public String toString() {
        return "CopyOfBook{"
                + "ID=" + getID()
                + ", code=" + code
                + ", available=" + available
                //TODO: Imprimir os empréstismos sem entrar em loop infinito.
                + ", loans=" + loans
                + '}';
    }
}