public class Door implements Cloneable {
    @Override
    public Door clone() throws CloneNotSupportedException {
        return (Door) super.clone();
    }
}
