package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Author;
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
public class AuthorDAO extends DataAcessObject<Author, Long> {
/* 
    | AUTHOR | CREATE TABLE `author` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `NAME` varchar(50) NOT NULL,
    `BIRTHDATE` date DEFAULT NULL,
    `DEATHDATE` date DEFAULT NULL,
    `DEATHPLACE` varchar(100) DEFAULT NULL,
    `BIOGRAPHY` varchar(300) NOT NULL,
    `DELETED` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `NAME` (`NAME`,`BIRTHDATE`,`DEATHDATE`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO AUTHOR"
                + "(NAME, BIRTHDATE, DEATHDATE, DEATHPLACE, BIOGRAPHY)"
                + "VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE AUTHOR"
                + "SET NAME = ?, BIRTHDATE = ?, DEATHDATE = ?, DEATHPLACE = ?, BIOGRAPHY = ?"
                + "WHERE ID = ? AND DELETED = FALSE;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, NAME, BIRTHDATE, DEATHDATE, DEATHPLACE, BIOGRAPHY"
                + "FROM AUTHOR"
                + "WHERE ID = ? AND DELETED = FALSE;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, NAME, BIRTHDATE, DEATHDATE, DEATHPLACE, BIOGRAPHY"
                + "FROM AUTHOR"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE AUTHOR SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Author e) {
        try {
            pst.setString(1, e.getName());
            pst.setObject(2, Date.valueOf(e.getBirthdate()), java.sql.Types.DATE);
            pst.setObject(3, Date.valueOf(e.getDeathDate()), java.sql.Types.DATE);
            pst.setObject(4, e.getDeathPlace(), java.sql.Types.VARCHAR);
            pst.setObject(5, e.getBiography(), java.sql.Types.VARCHAR);
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(6, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Author buildEntity(ResultSet rst) {
        Author a = new Author();

        try {
            a.setID(rst.getLong("ID"));
            a.setName(rst.getString("NAME"));
            a.setBirthdate(rst.getObject("BIRTHDATE", LocalDate.class));
            a.setDeathDate(rst.getObject("DEATHDATE", LocalDate.class));
            a.setDeathPlace(rst.getString("DEATHPLACE"));
            a.setBiography(rst.getString("BIOGRAPHY"));
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
}