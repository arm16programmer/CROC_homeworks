package croc_homeworks.lesson3;

/**
 * Класс категории автомобилей.
 */
public abstract class Vehicle implements Transport {
    private int transportID;
    private String licensePlate;
    private String transportBrand;
    private int dateOfRent;
    private int numberOfRentalDays;
    private static Vehicle[] arr = new Vehicle[10];

    public Vehicle() {}
    public Vehicle(int transportID, String licensePlate, String transportBrand, int dateOfRent, int numberOfRentalDays) {
        this.transportID = transportID;
        this.licensePlate = licensePlate;
        this.transportBrand = transportBrand;
        this.dateOfRent = dateOfRent;
        this.numberOfRentalDays = numberOfRentalDays;
    }

    public static Vehicle[] getArr() {
        return arr;
    }

    public int getTransportID() {
        return transportID;
    }
    public void setTransportID(int transportID) {
            this.transportID = transportID;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public String getTransportBrand() {
        return transportBrand;
    }
    public void setTransportBrand(String transportBrand) {
        this.transportBrand = transportBrand;
    }
    public int getDateOfRent() {
        return dateOfRent;
    }
    public void setDateOfRent(int dateOfRent) {
        this.dateOfRent = dateOfRent;
    }
    public int getNumberOfRentalDays() {
        return numberOfRentalDays;
    }
    public void setNumberOfRentalDays(int numberOfRentalDays) {
        this.numberOfRentalDays = numberOfRentalDays;
    }
    @Override
    public abstract boolean toRemoveFaultyTransport();

    @Override
    public abstract boolean toRegister();

    public abstract boolean toRegister(PassengerCar theFirst);
}
