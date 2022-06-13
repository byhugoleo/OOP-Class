package hugo.ifnmg.livraria.entidade;

import java.time.LocalDate;

/**
 * Classe Emprestimo.
 */
public final class Emprestimo extends Entidade {
// Propriedades
    private Funcionario funcionario;
    private Exemplar exemplar;
    private Discente discente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolucaoLimite;
    private String observacao;

//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Emprestimo() {}
    
    public Emprestimo(Funcionario funcionario, Exemplar exemplar, Discente discente, LocalDate dataEmprestimo, LocalDate dataDevolucao, LocalDate dataDevolucaoLimite, String observacao) {
        this.funcionario = funcionario;
        this.exemplar = exemplar;
        this.discente = discente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataDevolucaoLimite = dataDevolucaoLimite;
        this.observacao = observacao;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Discente getDiscente() {
        return discente;
    }

    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataDevolucaoLimite() {
        return dataDevolucaoLimite;
    }

    public void setDataDevolucaoLimite(LocalDate dataDevolucaoLimite) {
        this.dataDevolucaoLimite = dataDevolucaoLimite;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
//</editor-fold>

// Métodos
    @Override
    public String toString() {
        return "Emprestimo{"
                + "funcionario=" + funcionario
                + ", exemplar=" + exemplar
                + ", discente=" + discente
                + ", dataEmprestimo=" + dataEmprestimo.toString()
                + ", dataDevolucao=" + dataDevolucao.toString()
                + ", dataDevolucaoLimite=" + dataDevolucaoLimite.toString()
                + ", observacao=" + observacao
                + '}';
    }
}