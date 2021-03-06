package hugo.ifnmg.bike.builder;

import hugo.ifnmg.bike.builder.bikes.Bike;
import hugo.ifnmg.bike.builder.director.Director;
import hugo.ifnmg.bike.builder.builders.BikeBuilder;

/**
 * Class for tests.
 * 
 * @author byhugoleo
 */
public class Program {

    public static void main(String[] args) {
        Director director = new Director();
        BikeBuilder builder = new BikeBuilder();
        
        director.constructBMXBike(builder);
        Bike BMX = builder.getResult();
        System.out.println(BMX);
        
        director.constructMountainBike(builder);
        Bike mountain = builder.getResult();
        System.out.println(mountain);
        
        director.constructSpeedBike(builder);
        Bike speed = builder.getResult();
        System.out.println(speed);
        
        director.constructUrbanBike(builder);
        Bike urban = builder.getResult();
        System.out.println(urban);
    }
}