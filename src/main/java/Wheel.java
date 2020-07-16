public class Wheel implements Cloneable {
    @Override
    public Wheel clone() throws CloneNotSupportedException {
        return (Wheel) super.clone();
    }
}
