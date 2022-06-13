package hugo.ifnmg.livraria.entidade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Livro.
 */
public class Livro extends Entidade {
    private String titulo;
    private Integer edicao;
    private List<Autor> autores;
    private Editora editora;
    private Genero genero;
    private Integer numeroPaginas;
    private LocalDate dataPublicacao;
    private List<Exemplar> exemplares;
    private LocalDate dataCadastro;
    private BigDecimal preco;

//<editor-fold defaultstate="collapsed" desc="Construtores">
        public Livro() {
        autores = new ArrayList();
    }

    public Livro(String titulo, Integer edicao, List<Autor> autores, Editora editora, Genero genero, Integer numeroPaginas, LocalDate dataPublicacao, List<Exemplar> exemplares, LocalDate dataCadastro, BigDecimal preco) {
        this.titulo = titulo;
        this.edicao = edicao;
        this.autores = autores;
        this.editora = editora;
        this.genero = genero;
        this.numeroPaginas = numeroPaginas;
        this.dataPublicacao = dataPublicacao;
        this.exemplares = exemplares;
        this.dataCadastro = dataCadastro;
        this.preco = preco;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
//</editor-fold>

// Métodos
    public void addAutores(Autor autor) {
        this.autores.add(autor);
    }
    
    public void addExemplares(Exemplar exemplar) {
        exemplares.add(exemplar);
    }
    
    @Override
    public String toString() {
        return "Livro{" 
                + "titulo=" + titulo 
                + ", edicao=" + edicao 
                + ", autores=" + autores 
                + ", editora=" + editora 
                + ", genero=" + genero 
                + ", numeroPaginas=" + numeroPaginas 
                + ", dataPublicacao=" + dataPublicacao 
                + ", exemplares=" + exemplares 
                + ", dataCadastro=" + dataCadastro 
                + ", preco=" + preco 
                + '}';
    }
}