package subway.model.station;

import subway.utils.Utils;

public class Station {

    private final String name;

    public Station(String name) {
        this.name = Utils.deleteAllSpace(name);
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
