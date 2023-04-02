package croc_homeworks.lesson3;

/**
 * Класс легковых автомобилей, унаследованный от класса автомобилей
 */
public abstract class PassengerCar extends Vehicle {
    public PassengerCar() {}
    public PassengerCar(int transportID, String licensePlate, String transportBrand, int dateOfRent,
                 int numberOfRentalDays) {
        super(transportID, licensePlate, transportBrand,dateOfRent, numberOfRentalDays);
    }
}
