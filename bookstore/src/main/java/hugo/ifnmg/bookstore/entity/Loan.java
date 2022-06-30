package hugo.ifnmg.bookstore.entity;

import java.time.LocalDate;

/**
 * Entity that represents a Loan.
 */
public final class Loan extends Entity {
// Properties
    private Employee employee;
    private CopyOfBook copyOfBook;
    private Student student;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LocalDate deadlineReturnDate;
    private String note;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Loan() {}
    
    public Loan(Employee employee, CopyOfBook copyOfBook, Student student, LocalDate loanDate, LocalDate returnDate, LocalDate deadlineReturnDate, String note) {
        this.employee = employee;
        this.copyOfBook = copyOfBook;
        this.student = student;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.deadlineReturnDate = deadlineReturnDate;
        this.note = note;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CopyOfBook getCopyOfBook() {
        return copyOfBook;
    }

    public void setCopyOfBook(CopyOfBook copyOfBook) {
        this.copyOfBook = copyOfBook;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDeadlineReturnDate() {
        return deadlineReturnDate;
    }

    public void setDeadlineReturnDate(LocalDate deadlineReturnDate) {
        this.deadlineReturnDate = deadlineReturnDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
//</editor-fold>

// Methods
    @Override
    public String toString() {
        return "Loan{"
                + "ID=" + getID()
                + ", employeeID = "+ employee.getID()
                + ", employeeName=" + employee.getName()
                + ", copyOfBookCode=" + copyOfBook.getCode()
                + ", copyofBookAvailable=" + (copyOfBook.getAvailable()? "Available" : "Unavailable")
                + ", student=" + student.getName()
                + ", studentID="+ student.getID()
                + ", loanDate=" + loanDate.toString()
                + ", returnDate=" + returnDate.toString()
                + ", deadlineReturnDate=" + deadlineReturnDate.toString()
                + ", note=" + note
                + '}';
    }
}