package hugo.ifnmg.bookstore.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity that represents a Book.
 */
public class Book extends Entity {
// Properties
    private String title;
    private Integer edition;
    private List<Author> authors;
    private Publisher publisher;
    private Genre genre;
    private Integer numberPages;
    private LocalDate publicationDate;
    private List<CopyOfBook> copiesOfBook;
    private BigDecimal price;

//<editor-fold defaultstate="collapsed" desc="Constructors">
        public Book() {
        authors = new ArrayList();
        copiesOfBook = new ArrayList();
    }

    public Book(String title, Integer edition, List<Author> authors, Publisher publisher, Genre genre, Integer numberPages, LocalDate publicationDate, List<CopyOfBook> copiesOfBook, BigDecimal price) {
        this.title = title;
        this.edition = edition;
        this.authors = authors;
        this.publisher = publisher;
        this.genre = genre;
        this.numberPages = numberPages;
        this.publicationDate = publicationDate;
        this.copiesOfBook = copiesOfBook;
        this.price = price;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(Integer numberPages) {
        this.numberPages = numberPages;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<CopyOfBook> getCopiesOfBook() {
        return copiesOfBook;
    }

    public void setCopiesOfBook(List<CopyOfBook> copiesOfBook) {
        this.copiesOfBook = copiesOfBook;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
//</editor-fold>

// Methods
    public void addAuthors(Author author) {
        this.authors.add(author);
    }
    
    public void addCopiesOfBook(CopyOfBook copyOfBook) {
        copiesOfBook.add(copyOfBook);
    }
    
    @Override
    public String toString() {
        String text = "Book{"
                + "ID=" + getID()
                + ", title=" + title
                + ", edition=" + edition
                + ", authors=" + authors
                + ", publisher=" + publisher
                + ", genre=" + genre
                + ", numberPages=" + numberPages
                + ", publicationDate=" + publicationDate
                + ", copiesOfBook=";
                //TODO: imprimir as cópias dos livros sem entrar em loop infinito.
        text += ", price=" + price
                + '}';
        return text;
    }
}