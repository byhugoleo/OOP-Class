package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.CopyOfBook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete operations that support CRUD procedures on database objects.
 */
public class CopyOfBookDAO extends DataAcessObject<CopyOfBook, Long> {
/*
    | COPYOFBOOK | CREATE TABLE `copyofbook` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `CODE` varchar(20) NOT NULL,
    `AVAILABLE` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `CODE` (`CODE`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO COPYOFBOOK"
                + "(CODE, AVAILABLE)"
                + "VALUES (?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE COPYOFBOOK"
                + "SET CODE = ?, AVAILABLE = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, CODE, AVAILABLE"
                + "FROM COPYOFBOOK"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, CODE, AVAILABLE"
                + "FROM COPYOFBOOK;";
    }

    @Override
    public String getDeleteStatementByID() {
        return "DELETE FROM COPYOFBOOK WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, CopyOfBook cB) {
        try {
            pst.setString(1, cB.getCode());
            pst.setBoolean(2, cB.getAvailable());
            if (cB.getID() != null && cB.getID() != 0)
                pst.setLong(3, cB.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public CopyOfBook buildEntity(ResultSet rst) {
        CopyOfBook cB = new CopyOfBook();
        try {
            cB.setID(rst.getLong("ID"));
            cB.setCode(rst.getString("CODE"));
            cB.setAvailable(rst.getBoolean("AVAILABLE"));
        } catch (SQLException ex) {
            Logger.getLogger(CopyOfBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cB;
    }
}