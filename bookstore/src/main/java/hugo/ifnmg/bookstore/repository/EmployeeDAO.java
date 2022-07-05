package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete operations that support CRUD procedures on database objects.
 */
public class EmployeeDAO extends DataAcessObject<Employee, Long> {
/* 
    | EMPLOYEE | CREATE TABLE `employee` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `NAME` varchar(50) NOT NULL,
    `CPF` varchar(11) NOT NULL,
    `EMAIL` varchar(255) DEFAULT NULL,
    `PASSWORD` varchar(32) NOT NULL,
    `ADDRESS` varchar(100) NOT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `CPF` (`CPF`),
    UNIQUE KEY `EMAIL` (`EMAIL`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO EMPLOYEE"
                + " (NAME, CPF, EMAIL, PASSWORD, ADDRESS)"
                + " VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE EMPLOYEE"
                + " SET NAME = ?, CPF = ?, EMAIL = ?, PASSWORD = ?, ADDRESS = ?"
                + " WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, NAME, CPF, EMAIL, PASSWORD, ADDRESS"
                + " FROM EMPLOYEE"
                + " WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, NAME, CPF, EMAIL, PASSWORD, ADDRESS"
                + " FROM EMPLOYEE"
                + " WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatementByID() {
        return "DELETE FROM EMPLOYEE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Employee e) {
        try {
            pst.setString(1, e.getName());
            pst.setString(2, e.getCPF());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getPassword());
            pst.setString(5, e.getAddress());
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(6, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Employee buildEntity(ResultSet rst) {
        Employee e = new Employee();
        try {
            e.setID(rst.getLong("ID"));
            e.setName(rst.getString("NAME"));
            e.setCPF(rst.getString("CPF"));
            e.setEmail(rst.getString("EMAIL"));
            e.setPassword(rst.getString("PASSWORD"));
            e.setAddress(rst.getString("ADDRESS"));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
}