/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hugo.ifnmg.bookstore.repository;

import java.sql.Date;
import hugo.ifnmg.bookstore.entity.Emprestimo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * CREATE TABLE EMPRESTIMO (
-> ID SERIAL PRIMARY KEY,
-> DATAEMPRESTIMO DATE ,
->DATADEVOLUCAO DATE,
->DATADEVOLUCAOLIMITE,
->OBSERVACAO VARCHAR(100)
);
 */
public class EmprestimoDAO extends DataAcessObject<Emprestimo, Long> {

    @Override
    public String getInsertStatement() {
        return "INSERT INTO EMPRESTIMO"
                + "(DATAEMPRESTIMO, DATADEVOLUCAO, DATADEVOLUCAOLIMITE, OBSERVACAO)"
                + "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE EMPRESTIMO"
                + "DATAEMPRESTIMO = ?, DATADEVOLUCAO = ?, DATADEVOLUCAOLIMITE = ?, OBSERVACAO = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, DATAEMPRESTIMO, DATADEVOLUCAO, DATADEVOLUCAOLIMITE, OBSERVACAO"
                + "FROM EMPRESTIMO"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, DATAEMPRESTIMO, DATADEVOLUCAO, DATADEVOLUCAOLIMITE, OBSERVACAO"
                + "FROM EMPRESTIMO"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE EMPRESTIMO SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Emprestimo e) {
        try {
            pst.setObject(1, Date.valueOf(e.getDataEmprestimo()), java.sql.Types.DATE);
            pst.setObject(2, Date.valueOf(e.getDataDevolucao()), java.sql.Types.DATE);
            pst.setObject(3, e.getDataDevolucaoLimite(), java.sql.Types.DATE);
            pst.setObject(4, e.getObservacao(), java.sql.Types.VARCHAR);
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(5, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Emprestimo buildEntity(ResultSet rst) {
        Emprestimo a = new Emprestimo();

        try {
            a.setID(rst.getLong("ID"));
            a.setDataEmprestimo(rst.getObject("DATAEMPRESTIMO", LocalDate.class));
            a.setDataDevolucao(rst.getObject("DATADEVOLUCAO", LocalDate.class));
            a.setDataDevolucaoLimite(rst.getObject("DATADEVOLUCAOLIMITE", LocalDate.class));
            a.setObservacao(rst.getString("OBSERVACAO"));
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
}
