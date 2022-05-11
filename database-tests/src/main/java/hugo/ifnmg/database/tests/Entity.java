package hugo.ifnmg.database.tests;

/**
 * Aspects common to all entities managed by the system.
 * 
 * @author byhugoleo
 */
public abstract class Entity {
// Properties
    private Long ID;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
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
