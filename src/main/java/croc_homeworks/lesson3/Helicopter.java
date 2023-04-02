package croc_homeworks.lesson3;

/**
 * Класс вертолетов, унаследованный от класса летальных транспортных средств
 */
public abstract class Helicopter extends Aircraft {
    public Helicopter() {}
    public Helicopter(int power, int maxSpeed, int numberOfEngines, int transportID) {
        super(power, maxSpeed, numberOfEngines, transportID);
    }
}
