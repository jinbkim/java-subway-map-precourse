package subway.repository;

import subway.domain.Station;
import subway.domain.Stations;

public class StationRepository {

    private static final Stations stations = new Stations();

    public static void add(Station station) {
        stations.add(station);
    }

}
