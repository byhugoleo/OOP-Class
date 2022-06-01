package hugo.ifnmg.bike.builder.builders;

import bikes.Bike;
import bikes.BikeType;

/**
 * Concrete builders implement steps defined in the common interface.
 *
 * @author byhugoleo
 */
public class BikeBuilder implements Builder {
// Properties
    private Bike bike;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public BikeBuilder() {
        bike = new Bike();
    }
//</editor-fold>

// Methods
    @Override
    public void reset() {
        bike = new Bike();
    }

   @Override
    public void setBikeType(BikeType type) {
        bike.setType(type);
        System.out.println(">>\\ Type has been set.");
    }

    @Override
    public void setColor(String color) {
        bike.setColor(color);
        System.out.println(">>\\ Color has been set.");
    }
    
    @Override
    public void setFrame() {
        System.out.println(">>\\ Frame has been set.");
    }

    @Override
    public void setGears() {
        System.out.println(">>\\ Gears has been set.");
    }

    @Override
    public void setWheels() {
        System.out.println(">>\\ Wheels has been set.");
    }

    @Override
    public void setAcessories() {
        System.out.println(">>\\ Acessories has been set.");
    }
    
    public Bike getResult() {
        Bike tmp = this.bike;
        reset();
        return tmp;
    }
}