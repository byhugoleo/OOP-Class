package hugo.ifnmg.database.tests;

/**
 * Aspects common to all entities managed by the system.
 * 
 * @author byhugoleo
 */
public abstract class Entity {
// Properties
    private String ID;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Entity() {
    }
    public Entity(String ID) {
        this.ID = ID;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
//</editor-fold>
}
