package hugo.ifnmg.livraria.repositorio;

import hugo.ifnmg.livraria.entidade.Autor;
import hugo.ifnmg.livraria.entidade.Exemplar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class ExemplarDAO extends DataAcessObject<Exemplar, Long> {
/*
    | EXEMPLAR | CREATE TABLE `exemplar` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `CODIGO` bigint(20) NOT NULL,
    `DISPONIVEL` tinyint(1) DEFAULT '0',
    `DELETADO` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO EXEMPLAR"
                + "(CODIGO, DISPONIVEL)"
                + "VALUES (?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE EXEMPLAR"
                + "SET CODIGO = ?, DISPONIVEL = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, CODIGO, DISPONIVEL"
                + "FROM EXEMPLAR"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, CODIGO, DISPONIVEL"
                + "FROM EXEMPLAR"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE EXEMPLAR SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Exemplar e) {
        try {
            pst.setLong(1, e.getCodigo());
            pst.setBoolean(2, e.getDisponivel());
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(3, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Exemplar buildEntity(ResultSet rst) {
        Exemplar e = new Exemplar();

        try {
            e.setID(rst.getLong("ID"));
            e.setCodigo(rst.getLong("CODIGO"));
            e.setDisponivel(rst.getBoolean("DISPONIVEL"));
        } catch (SQLException ex) {
            Logger.getLogger(ExemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
}