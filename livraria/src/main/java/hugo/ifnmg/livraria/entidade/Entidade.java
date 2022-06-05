package hugo.ifnmg.livraria.entidade;

/**
 * Aspects common to all entities managed by the system.
 */
public abstract class Entidade {
// Propriedades
    private Long ID;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Entidade() {}
    
    public Entidade(Long ID) {
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