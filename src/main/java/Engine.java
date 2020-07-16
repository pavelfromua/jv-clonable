import java.util.ArrayList;

public class Engine implements Cloneable {
    private ArrayList<Cilinder> cilinders = new ArrayList<>();
    private ArrayList<Piston> pistons = new ArrayList<>();
    private Gasket gasket;
    private CilinderHead cilinderHead;
    private MotorHousing motorHousing;

    public void preparingGas() {
        System.out.println("Gas is mixed");
    }

    public ArrayList<Cilinder> getCilinders() {
        return cilinders;
    }

    public void setCilinders(int number) {
        this.cilinders = cilinders;
    }

    public ArrayList<Piston> getPistons() {
        return pistons;
    }

    public void setPistons(ArrayList<Piston> pistons) {
        this.pistons = pistons;
    }

    public Gasket getGasket() {
        return gasket;
    }

    public void setGasket(Gasket gasket) {
        this.gasket = gasket;
    }

    public CilinderHead getCilinderHead() {
        return cilinderHead;
    }

    public void setCilinderHead(CilinderHead cilinderHead) {
        this.cilinderHead = cilinderHead;
    }

    public MotorHousing getMotorHousing() {
        return motorHousing;
    }

    public void setMotorHousing(MotorHousing motorHousing) {
        this.motorHousing = motorHousing;
    }

    @Override
    public Engine clone() throws CloneNotSupportedException {
        Engine newEngine = (Engine) super.clone();

        newEngine.setGasket(this.getGasket().clone());
        newEngine.setCilinderHead(this.getCilinderHead().clone());
        newEngine.setMotorHousing(this.getMotorHousing().clone());

        newEngine.cilinders = new ArrayList<>();
        for (Cilinder cilinder: this.getCilinders()) {
            newEngine.cilinders.add((Cilinder) cilinder.clone());
        }

        newEngine.pistons = new ArrayList<>();
        for (Piston piston: this.getPistons()) {
            newEngine.pistons.add((Piston) piston.clone());
        }

        return newEngine;
    }
}
