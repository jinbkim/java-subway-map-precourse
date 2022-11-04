package subway.model.station;

import java.util.List;
import subway.model.line.LineRepository;

public class StationRepository {

    private static Stations stations = new Stations();

    public static void add(Station station) {
        stations.add(station);
    }

    public static void delete(String stationName) {
        stations.delete(stationName);
        LineRepository.deleteStation(stationName);
    }

    public static List<Station> get() {
        return stations.get();
    }

    public static boolean isExist(String stationName) {
        return stations.isExist(stationName);
    }

    public static void clear() {
        stations = new Stations();
    }
}
