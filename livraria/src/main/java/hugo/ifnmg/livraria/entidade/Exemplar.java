package hugo.ifnmg.livraria.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Exemplar extends Entidade {
// Propriedades
    private Long codigo;
    private Boolean disponivel;
    List<Emprestimo> emprestimos;
    
//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Exemplar() {
        emprestimos = new ArrayList();
    }

    public Exemplar(Long codigo, Boolean disponivel, List<Emprestimo> emprestimos) {
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.emprestimos = emprestimos;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
//</editor-fold>
  
    @Override
    public String toString() {
        return "Exemplar{"
                + "codigo=" + codigo
                + ", disponivel=" + disponivel
                + ", emprestimos=" + emprestimos
                + '}';
    }
}