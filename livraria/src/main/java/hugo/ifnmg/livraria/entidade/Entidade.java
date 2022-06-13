package hugo.ifnmg.livraria.entidade;

/**
 * Aspectos comum para todas as entidades manuseadas pelo sistema.
 */
public abstract class Entidade {
// Propriedades
    private Long ID;
    
//<editor-fold defaultstate="collapsed" desc="Construtores">
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