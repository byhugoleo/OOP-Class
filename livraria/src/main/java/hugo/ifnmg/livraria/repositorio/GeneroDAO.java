/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hugo.ifnmg.livraria.repositorio;

import hugo.ifnmg.livraria.entidade.Genero;

/**
 *
 * @author Xande
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Xande
 */
public class GeneroDAO  extends DataAcessObject<Genero, Long> {

    @Override
    public String getInsertStatement() {
        return "INSERT INTO GENERO"
                + "(NOME)"
                + "VALUES (?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE GENERO"
                + "SET NOME = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, NOME"
                + "FROM GENERO"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, NOME"
                + "FROM GENERO"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE GENERO SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Genero e) {
        try {
            pst.setString(1, e.getNome());
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(2, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Genero buildEntity(ResultSet rst) {
        Genero a = new Genero();

        try {
            a.setID(rst.getLong("ID"));
            a.setNome(rst.getString("NOME"));
        } catch (SQLException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
}
