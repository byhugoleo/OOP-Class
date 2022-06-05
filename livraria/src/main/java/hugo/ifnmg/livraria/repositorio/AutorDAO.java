package hugo.ifnmg.livraria.repositorio;

import hugo.ifnmg.livraria.entidade.Autor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class AutorDAO extends DataAcessObject<Autor, Long> {
/* 
    | AUTOR | CREATE TABLE `autor` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `NOME` varchar(50) NOT NULL,
    `DATANASCIMENTO` date DEFAULT NULL,
    `DATAFALESCIMENTO` date DEFAULT NULL,
    `LOCALFALESCIMENTO` varchar(100) DEFAULT NULL,
    `BIOGRAFIA` varchar(300) NOT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO AUTOR"
                + "(NOME, DATANASCIMENTO, DATAFALESCIMENTO, LOCALFALESCIMENTO, BIOGRAFIA)"
                + "VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE AUTOR"
                + "SET NOME = ?, DATANASCIMENTO = ?, DATAFALESCIMENTO = ?, LOCALFALESCIMENTO = ?, BIOGRAFIA = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, NOME, DATANASCIMENTO, DATAFALESCIMENTO, LOCALFALESCIMENTO, BIOGRAFIA"
                + "FROM AUTOR"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, NOME, DATANASCIMENTO, DATAFALESCIMENTO, LOCALFALESCIMENTO, BIOGRAFIA"
                + "FROM AUTOR"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE AUTOR SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Autor e) {
        try {
            pst.setString(1, e.getNome());
            pst.setObject(2, Date.valueOf(e.getDataNascimento()), java.sql.Types.DATE);
            pst.setObject(3, Date.valueOf(e.getDataFalescimento()), java.sql.Types.DATE);
            pst.setObject(4, e.getLocalFalescimento(), java.sql.Types.VARCHAR);
            pst.setObject(5, e.getBiografia(), java.sql.Types.VARCHAR);
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(6, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Autor buildEntity(ResultSet rst) {
        Autor a = new Autor();

        try {
            a.setID(rst.getLong("ID"));
            a.setNome(rst.getString("NOME"));
            a.setDataNascimento(rst.getObject("DATANASCIMENTO", LocalDate.class));
            a.setDataFalescimento(rst.getObject("DATAFALESCIMENTO", LocalDate.class));
            a.setLocalFalescimento(rst.getString("LOCALFALESCIMENTO"));
            a.setBiografia(rst.getString("BIOGRAFIA"));
        } catch (SQLException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}