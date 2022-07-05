package hugo.ifnmg.bookstore.entity;

/**
 * Entity that represents a relation between Author and Book.
 */
public class AuthorBook extends Entity {
// Properties
    private Long authorID;
    private Long bookID;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public AuthorBook() {}
    
    public AuthorBook(Long authorID, Long bookID) {
        this.authorID = authorID;
        this.bookID = bookID;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }
//</editor-fold>

// Methods
    @Override
    public String toString() {
        return "AuthorBook{"
                + "ID=" + getID()
                + ", authorID=" + authorID
                + ", bookID=" + bookID
                + "}";
    }
}