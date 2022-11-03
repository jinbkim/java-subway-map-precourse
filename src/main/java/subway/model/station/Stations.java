package subway.model.station;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stations {

    private List<Station> stations = new ArrayList<>();

    public Stations() {
    }

    public Stations(List<String> stations) {
        this.stations = stations.stream()
            .map(Station::new)
            .collect(Collectors.toList());
    }

    public void add(Station station) {
        if (!stations.contains(station)) {
            stations.add(station);
        }
    }

    public boolean delete(String name) {
        return stations.removeIf(station -> station.isSameName(name));
    }

    public List<Station> get() {
        return stations;
    }
}
