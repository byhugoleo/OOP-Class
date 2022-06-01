package hugo.ifnmg.bike.builder.builders;
import hugo.ifnmg.bike.builder.bikes.BikeType;

/**
 * Builder interface defines all possible ways to configure a product.
 *
 * @author byhugoleo
 */
public interface Builder {
    public void reset();
    public void setBikeType(BikeType type);
    public void setColor(String color);
    public void setFrame();
    public void setGears();
    public void setWheels();
    public void setAcessories();
}