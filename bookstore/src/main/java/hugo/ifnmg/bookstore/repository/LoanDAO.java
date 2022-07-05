package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Loan;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete operations that support CRUD procedures on database objects.
 */
public class LoanDAO extends DataAcessObject<Loan, Long> {
/*
    | LOAN  | CREATE TABLE `loan` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `LOANDATE` date NOT NULL,
    `RETURNDATE` date DEFAULT NULL,
    `DEADLINERETURNDATE` date NOT NULL,
    `NOTE` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO LOAN"
                + " (LOANDATE, RETURNDATE, DEADLINERETURNDATE, NOTE)"
                + " VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE LOAN"
                + " LOANDATE = ?, RETURNDATE = ?, DEADLINERETURNDATE = ?, NOTE = ?"
                + " WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, LOANDATE, RETURNDATE, DEADLINERETURNDATE, NOTE"
                + " FROM LOAN"
                + " WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, LOANDATE, RETURNDATE, DEADLINERETURNDATE, NOTE"
                + " FROM LOAN;";
    }

    @Override
    public String getDeleteStatementByID() {
        return "DELETE FROM LOAN WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Loan l) {
        try {
            pst.setObject(1, Date.valueOf(l.getLoanDate()), java.sql.Types.DATE);
            pst.setObject(2, Date.valueOf(l.getReturnDate()), java.sql.Types.DATE);
            pst.setObject(3, l.getDeadlineReturnDate(), java.sql.Types.DATE);
            pst.setString(4, l.getNote());
            if (l.getID() != null && l.getID() != 0)
                pst.setLong(5, l.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Loan buildEntity(ResultSet rst) {
        Loan l = new Loan();
        try {
            l.setID(rst.getLong("ID"));
            l.setLoanDate(rst.getObject("LOANDATE", LocalDate.class));
            l.setReturnDate(rst.getObject("RETURNDATE", LocalDate.class));
            l.setDeadlineReturnDate(rst.getObject("DEADLINERETURNDATE", LocalDate.class));
            l.setNote(rst.getString("NOTE"));
        } catch (SQLException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }   
}