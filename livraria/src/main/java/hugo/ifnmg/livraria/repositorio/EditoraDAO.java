package hugo.ifnmg.livraria.repositorio;

import hugo.ifnmg.livraria.entidade.Editora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 */
public class EditoraDAO extends DataAcessObject<Editora, Long> {

    @Override
    public String getInsertStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectStatementByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectStatementAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDeleteStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void buildStatement(PreparedStatement pst, Editora e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Editora buildEntity(ResultSet rst) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
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

}