package hugo.ifnmg.bookstore.entity;

/**
 * Classe base pessoa.
 */
public class Pessoa extends Entity {
// Propriedades
    private String nome;
    private String cpf;
    private String email;
    private String endereco;

//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Pessoa() {}
    
    public Pessoa(String nome, String cpf, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
//</editor-fold>

// Métodos
    @Override
    public String toString() {
        String text;
        text = ">>\\Pessoa={nome=" + nome
                + ", cpf=" + cpf
                + ", email=" + email
                + ", endereco=" + endereco
                + "}";
        return text;
    }
}