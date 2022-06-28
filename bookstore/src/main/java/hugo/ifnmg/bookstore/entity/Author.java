package hugo.ifnmg.bookstore.entity;

import hugo.ifnmg.bookstore.util.Util;
import java.time.LocalDate;

/**
 * Entity that represents an Author.
 */
public final class Author extends Entity {
// Properties
    private String name;
    private LocalDate birthdate;
    private LocalDate deathDate;
    private String deathPlace;
    private String biography;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Author() {}
    
    public Author(String name, LocalDate birthdate, LocalDate deathDate, String deathPlace, String biography) {
        this.name = name;
        this.birthdate = birthdate;
        this.deathDate = deathDate;
        this.deathPlace = deathPlace;
        this.biography = biography;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.length() > 50)
            throw new IllegalArgumentException(">> Invalid name length!");
        if (Util.isValidName(name))
            this.name = name;
        else
            throw new IllegalArgumentException(">> Invalid name!");
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) throws IllegalArgumentException {
        if (this.deathDate == null)
            this.birthdate = birthdate;
        else if (this.deathDate.isAfter(birthdate))
            this.birthdate = birthdate;
        else
            throw new IllegalArgumentException(">> Invalid birthdate!");
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) throws IllegalArgumentException {
        if (this.birthdate == null)
            this.deathDate = deathDate;
        else if (this.birthdate.isBefore(deathDate))
            this.deathDate = deathDate;
        else
            throw new IllegalArgumentException(">> Invalid deathDate!");
        this.deathDate = deathDate;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) throws IllegalArgumentException {
        if (deathPlace.length() > 100)
            throw new IllegalArgumentException(">> Invalid deathPlace!");
        this.deathPlace = deathPlace;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) throws IllegalArgumentException {
        if (biography.length() > 300)
            throw new IllegalArgumentException(">> Invalid biography!");
        this.biography = biography;
    }
//</editor-fold>

// Methods
    @Override
    public String toString() {
        return "Author{"
                + "ID=" + getID()
                + ", name=" + name
                + ", birthdate=" + birthdate.toString()
                + ", deathDate=" + deathDate.toString()
                + ", deathPlace=" + deathPlace
                + ", biography=" + biography
                + '}';
    }
}