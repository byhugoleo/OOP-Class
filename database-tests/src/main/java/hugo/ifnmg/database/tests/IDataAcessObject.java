package hugo.ifnmg.database.tests;

/**
 * Definition of required methods in Data Access Object classes
 * 
 * @author byhugoleo
 * @param <E>: Entity
 * @param <K>: Key
 */
public interface IDataAcessObject<E, K> {
    /**
     * Entity save operation in the database
     *
     * @param e Entity to be saved
     * @return Saved entity primary key
     */
    public K toSave(E e);
}
