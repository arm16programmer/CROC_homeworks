package croc_homeworks.lesson3;

/**
 * Класс грузовых автомобилей, унаследованный от класса автомобилей
 */
public abstract class Truck extends Vehicle {
        private int loadCapacity;
        public Truck() {}
        public Truck(int transportID, String licensePlate, String transportBrand, int dateOfRent,
                     int numberOfRentalDays, int loadCapacity) {
            super(transportID, licensePlate, transportBrand,dateOfRent, numberOfRentalDays);
            this.loadCapacity = loadCapacity;
        }
        public int getLoadCapacity() {
            return loadCapacity;
        }
        public void setLoadCapacity() {
            this.loadCapacity = loadCapacity;
        }
}
