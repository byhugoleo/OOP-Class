package director;

import bikes.BikeType;
import hugo.ifnmg.bike.builder.builders.Builder;

/**
 * Director defines the order of building steps.
 * 
 * @author byhugoleo
 */
public class Director {
    public void constructBMXBike(Builder builder) {
        builder.setBikeType(BikeType.BMX);
        builder.setColor("Red");
        builder.setFrame();
        builder.setGears();
        builder.setWheels();
        builder.setAcessories();
    }
    
    public void constructMountainBike(Builder builder) {
        builder.setBikeType(BikeType.MOUNTAIN);
        builder.setColor("White");
        builder.setFrame();
        builder.setGears();
        builder.setWheels();
        builder.setAcessories();
    }
    
    public void constructSpeedBike(Builder builder) {
        builder.setBikeType(BikeType.SPEED);
        builder.setColor("Black");
        builder.setFrame();
        builder.setGears();
        builder.setWheels();
        builder.setAcessories();
    }
    
    public void constructUrbanBike(Builder builder) {
        builder.setBikeType(BikeType.URBAN);
        builder.setColor("Black");
        builder.setFrame();
        builder.setGears();
        builder.setWheels();
        builder.setAcessories();
    }
}