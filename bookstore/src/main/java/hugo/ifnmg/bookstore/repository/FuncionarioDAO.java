package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class FuncionarioDAO extends DataAcessObject<Funcionario, Long> {
/* 
    | FUNCIONARIO | CREATE TABLE `funcionario` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `NOME` varchar(50) NOT NULL,
    `CPF` varchar(11) NOT NULL,
    `EMAIL` varchar(255) DEFAULT NULL,
    `ENDERECO` varchar(100) NOT NULL,
    `DELETADO` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `CPF` (`CPF`),
    UNIQUE KEY `EMAIL` (`EMAIL`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO FUNCIONARIO"
                + "(NOME, CPF, EMAIL, ENDERECO)"
                + "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE FUNCIONARIO"
                + "SET NOME = ?, CPF = ?, EMAIL = ?, ENDERECO = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, NOME, CPF, EMAIL, ENDERECO"
                + "FROM FUNCIONARIO"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, NOME, CPF, EMAIL, ENDERECO"
                + "FROM FUNCIONARIO"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE FUNCIONARIO SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Funcionario e) {
        try {
            pst.setString(1, e.getNome());
            pst.setObject(2, e.getCpf(), java.sql.Types.VARCHAR);
            pst.setObject(3, e.getEmail(), java.sql.Types.VARCHAR);
            pst.setObject(4, e.getEndereco(), java.sql.Types.VARCHAR);
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(5, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Funcionario buildEntity(ResultSet rst) {
        Funcionario f = new Funcionario();

        try {
            f.setID(rst.getLong("ID"));
            f.setNome(rst.getString("NOME"));
            f.setCpf(rst.getString("CPF"));
            f.setEmail(rst.getString("EMAIL"));
            f.setEndereco(rst.getString("ENDERECO"));
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

}