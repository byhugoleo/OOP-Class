package hugo.ifnmg.livraria.repositorio;

import hugo.ifnmg.livraria.entidade.Autor;
import hugo.ifnmg.livraria.entidade.Discente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class DiscenteDAO extends DataAcessObject<Discente, Long> {
/*
    | DISCENTE | CREATE TABLE `discente` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `MATRICULA` varchar(30) NOT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `MATRICULA` (`MATRICULA`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO DISCENTE"
                + "(MATRICULA)"
                + "VALUES (?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE DISCENTE"
                + "SET MATRICULA = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, MATRICULA"
                + "FROM DISCENTE"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, MATRICULA"
                + "FROM DISCENTE"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE DISCENTE SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Discente e) {
        try {
            pst.setString(1, e.getMatricula());
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(6, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Discente buildEntity(ResultSet rst) {
        Discente d = new Discente();

        try {
            d.setID(rst.getLong("ID"));
            d.setMatricula(rst.getString("MATRICULA"));
        } catch (SQLException ex) {
            Logger.getLogger(DiscenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}