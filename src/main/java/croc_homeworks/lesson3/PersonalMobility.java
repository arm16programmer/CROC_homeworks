package croc_homeworks.lesson3;

/**
 * Класс категории средств индивидуальной мобильности
 */
public abstract class PersonalMobility implements Transport {
        private int places;
        private int maxSpeed;
        private int transportID;

        public PersonalMobility() {}
        public PersonalMobility(int places, int maxSpeed, int transportID) {
            this.places = places;
            this.maxSpeed = maxSpeed;
            this.transportID = transportID;
        }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }   public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getTransportID() {
        return transportID;
    }

    public void setTransportID(int transportID) {
        this.transportID = transportID;
    }
}
