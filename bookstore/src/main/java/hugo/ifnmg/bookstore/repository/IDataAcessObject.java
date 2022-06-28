package hugo.ifnmg.bookstore.repository;

import java.util.List;

/**
 * Definition of required methods in Data Access Object classes.
 * 
 * @author byhugoleo
 * @param <E>: Entity.
 * @param <K>: Key.
 */
public interface IDataAcessObject<E, K> {
    /**
     * Save/update operation in the database.
     *
     * @param e Entity to be saved/updated.
     * @return Entity primary key.
     */
    public K saveOrUpdate(E e);
    
    /**
     * Fetch data from the database.
     *
     * @param ID Primary key.
     * @return An entity with data fetched from the database, or null
     * if not fetched.
     */
    public E getByID(K ID);
    
    /**
     * Fetch data from the database.
     * 
     * @return List of entities with data fetched from the database, or null if
     * not fetched.
     */
    public List<E> getAll();
    
    /**
     *
     * @param ID
     * @return 
     */
    public Boolean delete(K ID);
}
