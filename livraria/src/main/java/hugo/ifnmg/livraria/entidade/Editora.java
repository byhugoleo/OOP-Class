package hugo.ifnmg.livraria.entidade;

/**
 * Classe Editora.
 */
public final class Editora extends Entidade{
// Propriedades
    private String nome;
    private String endereco;
    private String telefone;
    private String cnpj;
    
//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Editora() {}

    public Editora(String nome, String endereco, String telefone, String cnpj) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
//</editor-fold>

// Métodos
    @Override
    public String toString() {
        return "Editora{" 
                + "nome=" + nome 
                + ", endereco=" + endereco 
                + ", telefone=" + telefone 
                + ", cnpj=" + cnpj 
                + '}';
    }
}