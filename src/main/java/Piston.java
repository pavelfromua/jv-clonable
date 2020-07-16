public class Piston implements Cloneable {
    @Override
    public Piston clone() throws CloneNotSupportedException {
        return (Piston) super.clone();
    }
}
