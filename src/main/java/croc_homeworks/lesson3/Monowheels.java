package croc_homeworks.lesson3;

/**
 * Класс моноколес, унаследованный от класса персональных средств передвижения
 */
public abstract class Monowheels extends PersonalMobility {
    public Monowheels() {}
    public Monowheels(int places, int maxSpeed, int transportID) {
        super(places, maxSpeed, transportID);
    }

}
