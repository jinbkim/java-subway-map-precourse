package subway.model.station;

import java.util.List;

public class StationRepository {

    private static final Stations stations = new Stations();

    public static void add(Station station) {
        stations.add(station);
    }

    public static boolean delete(String name) {
        return stations.delete(name);
    }

    public static List<Station> get() {
        return stations.get();
    }
}
