package subway.model.station;

public class StationRepository {

    private static final Stations stations = new Stations();

    public static void add(Station station) {
        stations.add(station);
    }

    //    public static boolean deleteStation(String name) {
    //        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    //    }
가
    public static Stations get() {
        return stations;
    }
}
