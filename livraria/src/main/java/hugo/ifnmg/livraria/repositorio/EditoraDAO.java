package hugo.ifnmg.livraria.repositorio;

import hugo.ifnmg.livraria.entidade.Editora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class EditoraDAO extends DataAcessObject<Editora, Long> {
/* 
    | EDITORA | CREATE TABLE `editora` (
    `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `NOME` varchar(50) NOT NULL,
    `TELEFONE` bigint(20) NOT NULL,
    `CNPJ` varchar(10) NOT NULL,
    `DELETADO` tinyint(1) DEFAULT '0',
    PRIMARY KEY (`ID`),
    UNIQUE KEY `ID` (`ID`),
    UNIQUE KEY `CNPJ` (`CNPJ`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
*/
    @Override
    public String getInsertStatement() {
        return "INSERT INTO EDITORA"
                + "(NOME, TELEFONE, CNPJ)"
                + "VALUES (?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE EDITORA"
                + "SET NOME = ?, TELEFONE = ?, CNPJ = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, NOME, TELEFONE, CNPJ"
                + "FROM EDITORA"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, NOME, TELEFONE, CNPJ"
                + "FROM EDITORA"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE EDITORA SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Editora e) {
        try {
            pst.setString(1, e.getNome());
            pst.setLong(2, e.getTelefone());
            pst.setObject(3, e.getCnpj(), java.sql.Types.VARCHAR);
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(4, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Editora buildEntity(ResultSet rst) {
        Editora e = new Editora();

        try {
            e.setID(rst.getLong("ID"));
            e.setNome(rst.getString("NOME"));
            e.setTelefone(rst.getLong("TELEFONE"));
            e.setCnpj(rst.getString("CNPJ"));
        } catch (SQLException ex) {
            Logger.getLogger(EditoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
}