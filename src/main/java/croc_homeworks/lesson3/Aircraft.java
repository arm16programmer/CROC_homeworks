package croc_homeworks.lesson3;

/**
 * Класс категории летательных транспортных средств
 */
public abstract class Aircraft implements Transport {
    private int power;
    private int maxSpeed;
    private int numberOfEngines;
    private int transportID;
    public Aircraft() {}
    public Aircraft(int power, int maxSpeed, int numberOfEngines, int transportID) {
        this.power = power;
        this.maxSpeed = maxSpeed;
        this.numberOfEngines = numberOfEngines;
        this.transportID = transportID;

    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public int getTransportID() {
        return transportID;
    }

    public void setTransportID(int transportID) {
        this.transportID = transportID;
    }
    @Override
    public abstract boolean toRemoveFaultyTransport();

    @Override
    public abstract boolean toRegister();
}
