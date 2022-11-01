package subway.model;

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
        stations.add(station);
    }

}
