package hugo.ifnmg.bookstore.repository;

import hugo.ifnmg.bookstore.entity.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of general operations and definition of specific operations
 * for <i>Data Access Object</i>.
 *
 * @param <E>: Entity.
 * @param <K>: Key.
 */
public abstract class DataAcessObject<E, K> implements IDataAcessObject<E, K> {
    @Override
    public K saveOrUpdate(E e) {
        Long ID = 0L;
        if (((Entity) e).getID() == null || ((Entity) e).getID() == 0) {
            try (
                Connection c = DBConnection.getConnection();
                PreparedStatement pst = c.prepareStatement(getInsertStatement(), Statement.RETURN_GENERATED_KEYS);
            ) {
                buildStatement(pst, e);
                pst.executeUpdate();
                ResultSet rst = pst.getGeneratedKeys();
                if (rst.next())
                    ID = rst.getLong(1);
            } catch (SQLException ex) {
                System.out.println(">> Exception: " + ex);
            }
        } else {
            try (
                Connection c = DBConnection.getConnection();
                PreparedStatement pst = c.prepareStatement(getUpdateStatement());
                ) {
                    buildStatement(pst, e);
                    pst.executeUpdate();
                    ID = ((Entity) e).getID();
            } catch (SQLException ex) {
                System.out.println(">> Exception: " + ex);
            }
        }
        return (K) ID;
    }

    @Override
    public E getByID(K ID) {
        try (
            Connection c = DBConnection.getConnection();
            PreparedStatement pst= c.prepareStatement(getSelectStatementByID());
        ) {
            pst.setLong(1, (Long) ID);
            ResultSet rst = pst.executeQuery();
            if (rst.next())
                return buildEntity(rst);
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
        return null;
    }

    @Override
    public List<E> getAll() {
        ArrayList<E> entities = new ArrayList<>();

        try (
            Connection c = DBConnection.getConnection();
            PreparedStatement pst = c.prepareStatement(getSelectStatementAll());
        ) {
            ResultSet rst = pst.executeQuery();
            while (rst.next())
                entities.add(buildEntity(rst));
        } catch (SQLException ex) {
            System.out.println(">> Exception: " + ex);
        }
        
        if (entities.isEmpty())
            return null;
        return entities;
    }
    
    @Override
    public Boolean delete(K ID) {
        if ((Long) ID != 0 && (Long) ID != null) {
            try (
                Connection c = DBConnection.getConnection();
                PreparedStatement pst = c.prepareStatement(getDeleteStatement());
            ) {
                pst.setLong(1, (Long) ID);
                pst.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(">> Exception: " + ex);
            }
        }
        return true;
    }
    
    /**
     * Sentença SQL específica para cada tipo de objeto a ser persistido no
     * banco de dados.
     * 
     * @return SQL insert statement.
     */
    public abstract String getInsertStatement();

    /**
     * Sentença SQL específica para cada tipo de objeto a ser atualizado no
     * banco de dados.
     *
     * @return Sentença SQL de atualização.
     */
    public abstract String getUpdateStatement();

    /**
     * Sentença SQL específica para cada tipo de objeto a ser localizado no
     * banco de dados.
     *
     * @return Sentença SQL de consulta de um registro.
     */
    public abstract String getSelectStatementByID();

    /**
     *
     * @return
     */
    public abstract String getSelectStatementAll();
    
    /**
     *
     * @return
     */
    public abstract String getDeleteStatement();
    
    /**
     * Monta a declaração SQL com os valores contidos no objeto recebido.
     *
     * @param pst Consulta a ser preparada.
     * @param e Objeto com valores a serem embutidos na consulta.
     */
    public abstract void buildStatement(PreparedStatement pst, E e);
    
    
    /**
     * Extrai um objeto PessoaFisica do resultado gerado pela consulta
     *
     * @param rst Registro recuperado do banco de dados
     * @return PessoaFisica equivalente ao registro recebido
     */
    public abstract E buildEntity(ResultSet rst);
}
