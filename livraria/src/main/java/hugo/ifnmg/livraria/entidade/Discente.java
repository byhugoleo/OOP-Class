package hugo.ifnmg.livraria.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Discente extends Pessoa {
// Propriedades
    private String matricula;
    List <Emprestimo> emprestimos;

//<editor-fold defaultstate="collapsed" desc="Construtores">
    public Discente() {
        emprestimos = new ArrayList();
    }
    
    public Discente(List<Emprestimo> emprestimos, String nome, String cpf, String email, String endereco) {
        super(nome, cpf, email, endereco);
        this.emprestimos = emprestimos;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
//</editor-fold>
    
// Métodos
    @Override
    public String toString() {
        return "Discente{" + "matricula=" + matricula 
                + ", emprestimos=" + emprestimos
                + '}';
    }
}