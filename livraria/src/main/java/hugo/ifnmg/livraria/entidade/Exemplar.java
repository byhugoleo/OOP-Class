package hugo.ifnmg.livraria.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Exemplar {
// Propriedades
    private Integer codigo;
    private Boolean disponivel;
    List<Emprestimo> emprestimos;
    
//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Exemplar() {
        emprestimos = new ArrayList();
    }

    public Exemplar(Integer codigo, Boolean disponivel, List<Emprestimo> emprestimos) {
        this.codigo = codigo;
        this.disponivel = disponivel;
        this.emprestimos = emprestimos;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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