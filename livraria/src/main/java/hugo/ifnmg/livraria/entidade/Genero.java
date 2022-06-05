package hugo.ifnmg.livraria.entidade;

/**
 *
 */
public class Genero extends Entidade {
// Propriedades
    private String nome;

//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Genero() {}

    public Genero(String nome) {
        this.nome = nome;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
//</editor-fold>

// Métodos
    @Override
    public String toString() {
        return "Genero{" + "nome=" + nome + '}';
    }
}