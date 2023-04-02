package croc_homeworks.lesson3;

/**
 * Класс бизнес-джетов, унаследованный от класса летальных транспортных средств
 */
public abstract class BusinessJet extends Aircraft{
    public BusinessJet() {}
    public BusinessJet(int power, int maxSpeed, int numberOfEngines, int transportID) {
        super(power, maxSpeed, numberOfEngines, transportID);
    }

}
