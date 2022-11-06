package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stations {

    private List<Station> stations = new ArrayList<>();

    public void add(Station station) {
        stations.add(station);
    }

    public List<Station> get() {
        return stations;
    }

    public boolean isExistStationName(String stationName) {
        return stations.stream()
                .anyMatch(station -> station.isSameName(stationName));
    }

    public void delete(String stationName) {
        stations = stations.stream()
                .filter(station -> !station.isSameName(stationName))
                .collect(Collectors.toList());
    }

    public void add(Station station, int order) {
        stations.add(order, station);
    }

    public int size() {
        return stations.size();
    }
}
