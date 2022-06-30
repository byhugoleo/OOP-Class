package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Genre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete operations that support CRUD procedures on database objects.
 */
public class GenreDAO extends DataAcessObject<Genre, Long> {
/*
    | GENRE | CREATE TABLE `genre` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `NAME` varchar(20) NOT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `NAME` (`NAME`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |    
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO GENRE"
                + "(NAME)"
                + "VALUES (?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE GENRE"
                + "SET NAME = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, NAME"
                + "FROM GENRE"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, NAME"
                + "FROM GENRE;";
    }

    @Override
    public String getDeleteStatementByID() {
        return "DELETE FROM GENRE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Genre g) {
        try {
            pst.setString(1, g.getName());
            if (g.getID() != null && g.getID() != 0)
                pst.setLong(2, g.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Genre buildEntity(ResultSet rst) {
        Genre g = new Genre();
        try {
            g.setID(rst.getLong("ID"));
            g.setName(rst.getString("NAME"));
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }
    
}
