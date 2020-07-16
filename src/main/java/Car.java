import java.util.ArrayList;

public class Car implements Cloneable {
    private Engine engine;
    private Frame frame;
    private ArrayList<Door> doors = new ArrayList<>();
    private ArrayList<Wheel> wheels = new ArrayList<>();
    private int doorsCount = 4;
    private int wheelsCount = 4;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Door> doors) {
        this.doors = doors;
    }

    public ArrayList<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(ArrayList<Wheel> wheels) {
        this.wheels = wheels;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car newCar = (Car) super.clone();

        newCar.setEngine((Engine) getEngine().clone());
        newCar.setFrame((Frame) getFrame().clone());

        newCar.wheels = new ArrayList<>();
        for (Wheel wheel: this.getWheels()) {
            newCar.wheels.add((Wheel) wheel.clone());
        }

        newCar.doors = new ArrayList<>();
        for (Door door: getDoors()) {
            newCar.doors.add((Door) door.clone());
        }

        return newCar;
    }
}
