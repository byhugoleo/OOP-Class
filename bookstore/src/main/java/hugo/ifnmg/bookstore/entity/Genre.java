package hugo.ifnmg.bookstore.entity;

/**
 * Entity that represents a Genre.
 */
public final class Genre extends Entity {
// Properties
    private String name;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Genre() {}

    public Genre(String name) {
        this.name = name;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//</editor-fold>

// Methods
    @Override
    public String toString() {
        return "Genre{"
                +"ID=" + getID() 
                + ", name=" + name
                + '}';
    }
}