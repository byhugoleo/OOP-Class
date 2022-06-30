package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Publisher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete operations that support CRUD procedures on database objects.
 */
public class PublisherDAO extends DataAcessObject<Publisher, Long> {
/* 
    | PUBLISHER | CREATE TABLE `publisher` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `NAME` varchar(50) NOT NULL,
    `ADDRESS` varchar(100) DEFAULT NULL,
    `PHONENUMBER` varchar(20) DEFAULT NULL,
    `CNPJ` varchar(10) NOT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `CNPJ` (`CNPJ`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO PUBLISHER"
                + "(NAME, ADDRESS, PHONENUMBER, CNPJ)"
                + "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE PUBLISHER"
                + "SET NAME = ?, ADDRESS = ?, PHONENUMBER = ?, CNPJ = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, NAME, ADDRESS, PHONENUMBER, CNPJ"
                + "FROM PUBLISHER"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, NAME, ADDRESS, PHONENUMBER, CNPJ"
                + "FROM PUBLISHER;";
    }

    @Override
    public String getDeleteStatementByID() {
        return "DELETE FROM PUBLISHER WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Publisher p) {
        try {
            pst.setString(1, p.getName());
            pst.setString(2, p.getAddress());
            pst.setString(3, p.getPhoneNumber());
            pst.setString(4, p.getCNPJ());
            if (p.getID() != null && p.getID() != 0)
                pst.setLong(5, p.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Publisher buildEntity(ResultSet rst) {
        Publisher p = new Publisher();
        try {
            p.setID(rst.getLong("ID"));
            p.setName(rst.getString("NAME"));
            p.setAddress(rst.getString("ADDRESS"));
            p.setPhoneNumber(rst.getString("PHONENUMBER"));
            p.setCNPJ(rst.getString("CNPJ"));
        } catch (SQLException ex) {
            Logger.getLogger(PublisherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}