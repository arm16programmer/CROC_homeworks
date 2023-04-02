package croc_homeworks.lesson3;

/**
 * Класс электоросамокатов, унаследованный от класса персональных средств передвижения
 */
abstract class ElectricScooter extends PersonalMobility {
    public ElectricScooter() {}
    public ElectricScooter(int places, int maxSpeed, int transportID) {
        super(places, maxSpeed, transportID);
    }

}
