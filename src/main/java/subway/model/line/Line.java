package subway.model.line;

import java.util.List;
import subway.model.station.Station;
import subway.model.station.Stations;
import subway.utils.Utils;

public class Line {

    private final String name;
    private final Stations stations;

    public Line(String name, List<String> stations) {
        this.name = Utils.deleteAllSpace(name);
        this.stations = new Stations(stations);
    }

    public Line(String name, String firstStation, String lastStation) {
        this.name = name;
        stations = new Stations(new Station(firstStation), new Station(lastStation));
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void addStation(String stationName, int order) {
        stations.add(new Station(stationName), order);
    }

    public void deleteStation(String stationName) {
        stations.delete(stationName);
    }

    public int findStationsSize() {
        return stations.findSize();
    }

    public String getName() {
        return name;
    }

    public Stations getStations() {
        return stations;
    }

    public boolean hasStation(String stationName) {
        return stations.isExist(stationName);
    }

}
