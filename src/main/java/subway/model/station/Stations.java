package subway.model.station;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stations {

    private List<Station> stations = new ArrayList<>();

    public Stations() {
    }

    public Stations(Station firstStation, Station lastStation) {
        stations.add(firstStation);
        stations.add(lastStation);
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

    public void add(Station station, int order) {
        if (!stations.contains(station)) {
            stations.add(order, station);
        }
    }

    public boolean delete(String stationName) {
        return stations.removeIf(station -> station.isSameName(stationName));
    }

    public boolean isExist(String stationName) {
        return stations.stream()
            .anyMatch(station -> station.isSameName(stationName));
    }

    public List<Station> get() {
        return stations;
    }
}
