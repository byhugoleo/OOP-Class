package hugo.ifnmg.listprocessing;

/**
 * Generalized class that has two parameters T and U, used for processing lists.
 * 
 * @author byhugoleo
 * @param <T> first element of the pair
 * @param <U> second element of the pair
 */
public class Pair<T, U> {
// Properties
    private T x;
    private U y;

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Pair() {}
    public Pair(T x, U y) {
        this.x = x;
        this.y = y;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getters/Setters">
     public T getX() {
        return x;
    }
    public void setX(T x) {
        this.x = x;
    }
    public U getY() {
        return y;
    }
    public void setY(U y) {
        this.y = y;
    }
//</editor-fold>
    
// Methods
    @Override
    public String toString() {
        return "Pair{" + "x=" + x + ", y=" + y + '}';
    }
}
