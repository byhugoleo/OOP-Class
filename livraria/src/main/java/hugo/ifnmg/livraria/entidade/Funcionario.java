package hugo.ifnmg.livraria.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Funcionário.
 */
public class Funcionario extends Pessoa{
// Propriedades
    List <Emprestimo> emprestimos;
    //TODO relacionamentos
    
//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Funcionario() {
        emprestimos = new ArrayList();
    }

    public Funcionario(List<Emprestimo> emprestimos, String nome, String cpf, String email, String endereco) {
        super(nome, cpf, email, endereco);
        this.emprestimos = emprestimos;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getter/Setter">
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
//</editor-fold>
}