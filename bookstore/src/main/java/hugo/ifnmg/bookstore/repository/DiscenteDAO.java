package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Discente;
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
    `MATRICULA` varchar(20) NOT NULL,
    `NOME` varchar(50) NOT NULL,
    `CPF` varchar(11) NOT NULL,
    `EMAIL` varchar(255) DEFAULT NULL,
    `ENDERECO` varchar(100) NOT NULL,
    `DELETADO` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
     UNIQUE KEY `MATRICULA` (`MATRICULA`),
    UNIQUE KEY `CPF` (`CPF`),
    UNIQUE KEY `EMAIL` (`EMAIL`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO DISCENTE"
                + "(MATRICULA, NOME, CPF, EMAIL, ENDERECO)"
                + "VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE DISCENTE"
                + "SET MATRICULA = ?, NOME = ?, CPF = ?, EMAIL = ?, ENDERECO = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, MATRICULA, NOME, CPF, EMAIL, ENDERECO"
                + "FROM DISCENTE"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, MATRICULA, NOME, CPF, EMAIL, ENDERECO"
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
            pst.setString(2, e.getNome());
            pst.setObject(3, e.getCpf(), java.sql.Types.VARCHAR);
            pst.setObject(4, e.getEmail(), java.sql.Types.VARCHAR);
            pst.setObject(5, e.getEndereco(), java.sql.Types.VARCHAR);
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
            d.setNome(rst.getString("NOME"));
            d.setCpf(rst.getString("CPF"));
            d.setEmail(rst.getString("EMAIL"));
            d.setEndereco(rst.getString("ENDERECO"));
        } catch (SQLException ex) {
            Logger.getLogger(DiscenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}