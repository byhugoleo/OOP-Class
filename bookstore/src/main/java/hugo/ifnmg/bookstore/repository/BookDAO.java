package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Book;
import java.math.BigDecimal;
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
public class BookDAO extends DataAcessObject<Book,Long>{
/*
    | BOOK  | CREATE TABLE `book` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `TITLE` varchar(50) NOT NULL,
    `EDITION` tinyint(4) DEFAULT '1',
    `NUMBERPAGES` int(11) NOT NULL,
    `PUBLICATIONDATE` date DEFAULT NULL,
    `PRICE` decimal(10,0) NOT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `TITLE` (`TITLE`,`EDITION`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO BOOK"
                + " (TITLE, EDITION, NUMBERPAGES, PUBLICATIONDATE, PRICE)"
                + " VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE BOOK"
                + " SET TITLE = ?, EDITION= ?, NUMBERPAGES= ?, PUBLICATIONDATE = ?, PRICE = ?"
                + " WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, TITLE, EDITION, NUMBERPAGES, PUBLICATIONDATE, PRICE"
                + " FROM BOOK"
                + " WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, TITLE, EDITION, NUMBERPAGES, PUBLICATIONDATE, PRICE"
                + " FROM BOOK;";
    }

    @Override
    public String getDeleteStatementByID() {
        return "DELETE FROM BOOK WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Book b) {
        try {
            pst.setString(1, b.getTitle());
            pst.setObject(2, b.getEdition(), java.sql.Types.TINYINT);
            pst.setInt(3, b.getNumberPages());
            pst.setObject(4, Date.valueOf(b.getPublicationDate()), java.sql.Types.DATE);
            pst.setObject(5, b.getPrice(), java.sql.Types.DECIMAL);
            if (b.getID() != null && b.getID() != 0)
                pst.setLong(6, b.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Book buildEntity(ResultSet rst) {
        Book b = new Book();
        try {
            b.setID(rst.getLong("ID"));
            b.setTitle(rst.getString("TITLE"));
            b.setEdition(rst.getObject("EDITION", Integer.class));
            b.setNumberPages(rst.getObject("NUMBERPAGES", Integer.class));
            b.setPublicationDate(rst.getObject("PUBLICATIONDATE", LocalDate.class));
            b.setPrice(rst.getObject("PRICE", BigDecimal.class));
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
}