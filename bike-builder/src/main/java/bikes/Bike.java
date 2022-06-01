package bikes;

/**
 * Bike is a product class.
 * 
 * @author byhugoleo
 */
public class Bike {
// Properties
    private BikeType type;
    private String color;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Bike() {}
    
    public Bike(BikeType type, String color) {
        this.type = type;
        this.color = color;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
//</editor-fold>
    
    @Override
    public String toString() {
        String text;
        text = ">>\\ Bike={BikeType=" + type.name()
                + ", Color=" + color + "}";
        return text;
    }
}