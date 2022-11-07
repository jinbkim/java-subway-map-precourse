package subway.repository;

import java.util.List;
import subway.domain.Station;
import subway.domain.Stations;

public class StationRepository {

    private static Stations stations = new Stations();

    public static void add(String stationName) {
        if (!stations.isExistStationName(stationName)) {
            stations.add(new Station(stationName));
        }
    }

    public static List<Station> get() {
        return stations.get();
    }

    public static void delete(String stationName) {
        stations.delete(stationName);
    }

    public static boolean isExistStationName(String stationName) {
        return stations.isExistStationName(stationName);
    }

    public static void clear() {
        stations = new Stations();
    }
}
