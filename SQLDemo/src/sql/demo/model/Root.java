package sql.demo.model;

import java.util.List;

public class Root {
    private List<Bus> bus;

    public Root() {

    }

    public Root(List<Bus> bus) {

        this.bus = bus;
    }

    public List<Bus> getBuses() {
        return bus;
    }

    public void setBuses(List<Bus> buses) {
        this.bus = buses;
    }

    @Override
    public String toString() {
        return "buses=" + bus +
                '}';
    }
}
