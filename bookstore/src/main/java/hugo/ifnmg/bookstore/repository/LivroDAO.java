/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Livro;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * create table livro(
 * 
    -> id int not null auto_increment primary key,
    -> titulo varchar(50)
    -> edicao tinyint unsigned not null default '1',
    -> numeroPaginas int not null,
    -> preco DECIMAL not null,
    -> DATAPUBLICACAO date DEFAULT NULL
    -> DATACADASTRO date DEFAULT NULL

 */
public class LivroDAO extends DataAcessObject<Livro,Long>{

    @Override
    public String getInsertStatement() {
        return "INSERT INTO LIVRO"
                + "(TITULO, EDICAO, NUMEROPAGINAS, PRECO, DATAPUBLICACAO, DATACADASTRO)"
                + "VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateStatement() {
        return "UPDATE LIVRO"
                + "SET TITULO = ?, EDICAO = ?, NUMEROPAGINAS = ?, PRECO = ?, DATAPUBLICACAO = ?, DATACADASTRO = ?"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementByID() {
        return "SELECT ID, TITULO, EDICAO, NUMEROPAGINAS, PRECO, DATAPUBLICACAO, DATACADASTRO"
                + "FROM LIVRO"
                + "WHERE ID = ?;";
    }

    @Override
    public String getSelectStatementAll() {
        return "SELECT ID, TITULO, EDICAO, NUMEROPAGINAS, PRECO, DATAPUBLICACAO, DATACADASTRO"
                + "FROM LIVRO"
                + "WHERE DELETED = FALSE;";
    }

    @Override
    public String getDeleteStatement() {
        return "UPDATE LIVRO SET DELETED = TRUE WHERE ID = ?;";
    }

    @Override
    public void buildStatement(PreparedStatement pst, Livro e) {
        try {
            pst.setString(1, e.getTitulo());
            pst.setObject(2, e.getNumeroPaginas(), java.sql.Types.INTEGER);
            pst.setObject(3, e.getPreco(), java.sql.Types.DECIMAL);
            pst.setObject(4, e.getEdicao(), java.sql.Types.TINYINT);
            pst.setObject(5, Date.valueOf(e.getDataPublicacao()), java.sql.Types.DATE);
            pst.setObject(5, Date.valueOf(e.getDataCadastro()), java.sql.Types.DATE);
            if (e.getID() != null && e.getID() != 0)
                pst.setLong(7, e.getID());
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
    }

    @Override
    public Livro buildEntity(ResultSet rst) {
        Livro a = new Livro();
        
        try {
            a.setID(rst.getLong("ID"));
            a.setTitulo(rst.getString("TITULO"));
            a.setEdicao(rst.getObject("EDICAO", Integer.class));
            a.setNumeroPaginas(rst.getObject("NUMEROPAGINAS", Integer.class));
            a.setPreco(rst.getObject("PRECO", BigDecimal.class));
            a.setDataPublicacao(rst.getObject("DATAPUBLICACAO", LocalDate.class));
            a.setDataCadastro(rst.getObject("DATACADASTRO", LocalDate.class));
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
}
