public class Gasket implements Cloneable {
    @Override
    public Gasket clone() throws CloneNotSupportedException {
        Gasket newGasket = (Gasket) super.clone();
        return newGasket;
    }
}
