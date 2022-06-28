package hugo.ifnmg.bookstore.entity;

/**
 * Aspects common to all entities managed by the system.
 */
public abstract class Entity {
// Propriedades
    private Long ID;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Entity() {}
    
    public Entity(Long ID) {
        this.ID = ID;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getID() {
        return ID;
    }
    
    public void setID(Long ID) {
        this.ID = ID;
    }
//</editor-fold>
}