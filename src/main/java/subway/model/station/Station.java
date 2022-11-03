package subway.model.station;

import subway.utils.Utils;

public class Station {

    private String name;

    public Station(String name) {
        this.name = Utils.deleteAllSpace(name);
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object station) {
        return isSameName(((Station) station).name);
    }
}
