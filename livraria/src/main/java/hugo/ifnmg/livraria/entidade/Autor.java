package hugo.ifnmg.livraria.entidade;

import java.time.LocalDate;

/**
 *
 */
public class Autor extends Entidade {
// Propriedades
    private String nome;
    private LocalDate dataNascimento;
    private LocalDate dataFalescimento;
    private String localFalescimento;
    private String biografia;

//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Autor() {}
    
    public Autor(String nome, LocalDate dataNascimento, LocalDate dataFalescimento, String localFalescimento, String biografia) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataFalescimento = dataFalescimento;
        this.localFalescimento = localFalescimento;
        this.biografia = biografia;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataFalescimento() {
        return dataFalescimento;
    }

    public void setDataFalescimento(LocalDate dataFalescimento) {
        this.dataFalescimento = dataFalescimento;
    }

    public String getLocalFalescimento() {
        return localFalescimento;
    }

    public void setLocalFalescimento(String localFalescimento) {
        this.localFalescimento = localFalescimento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
//</editor-fold>

// Métodos
    @Override
    public String toString() {
        return "Autor{" 
                + "nome=" + nome
                + ", dataNascimento=" + dataNascimento.toString()
                + ", dataFalescimento=" + dataFalescimento.toString()
                + ", localFalescimento=" + localFalescimento
                + ", biografia=" + biografia
                + '}';
    }
}