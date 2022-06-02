/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hugo.ifnmg.livraria.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xande
 */
public class Exemplar {
    //extends Livro
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
  
    //<editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "Exemplar{" 
                + "codigo=" + codigo 
                + ", disponivel=" + disponivel 
                + ", emprestimos=" + emprestimos //TODO verificar se nao esta criando um loop no toSring de Emprestimo
                + '}';
    }
//</editor-fold>
    
    
    
    
    
    
    
    
    
    
}
