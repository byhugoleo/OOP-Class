package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete operations that support CRUD procedures on database objects.
 */
public class StudentDAO extends DataAcessObject<Student, Long> {
/*
    | STUDENT | CREATE TABLE `student` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `ENROLLMENT` varchar(20) NOT NULL,
    `NAME` varchar(50) NOT NULL,
    `CPF` varchar(11) NOT NULL,
    `EMAIL` varchar(255) DEFAULT NULL,
    `PASSWORD` varchar(32) NOT NULL,
    `ADDRESS` varchar(100) NOT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `ENROLLMENT` (`ENROLLMENT`),
    UNIQUE KEY `CPF` (`CPF`),
    UNIQUE KEY `EMAIL` (`EMAIL`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO STUDENT"
                + " (ENROLLMENT, NAME, CPF, EMAIL, PASSWORD, ADDRESS)"
                + " VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE STUDENT"
                + " SET ENROLLMENT = ?, NAME = ?, CPF = ?, EMAIL = ?, PASSWORD = ?, ADDRESS = ?"
                + " WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, ENROLLMENT, NAME, CPF, EMAIL, PASSWORD, ADDRESS"
                + " FROM STUDENT"
                + " WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, STUDENT, NAME, CPF, EMAIL, PASSWORD, ADDRESS"
                + " FROM STUDENT;";
    }

    @Override
    public String getDeleteStatementByID() {
        return "DELETE FROM STUDENT WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Student s) {
        try {
            pst.setString(1, s.getEnrollment());
            pst.setString(2, s.getName());
            pst.setString(3, s.getCPF());
            pst.setString(4, s.getEmail());
            pst.setString(5, s.getPassword());
            pst.setString(6, s.getAddress());
            if (s.getID() != null && s.getID() != 0)
                pst.setLong(7, s.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Student buildEntity(ResultSet rst) {
        Student s = new Student();
        try {
            s.setID(rst.getLong("ID"));
            s.setEnrollment(rst.getString("ENROLLMENT"));
            s.setName(rst.getString("NAME"));
            s.setCPF(rst.getString("CPF"));
            s.setEmail(rst.getString("EMAIL"));
            s.setPassword(rst.getString("PASSWORD"));
            s.setAddress(rst.getString("ADDRESS"));
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}