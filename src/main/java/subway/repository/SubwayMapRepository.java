package subway.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;

public class SubwayMapRepository {

    private static final Map<Line, Stations> lineAndStations = new HashMap<>();

    public static void addStations(String lineName, List<String> stationsName) {
        Line line = LineRepository.findLineByName(lineName);
        Stations stations = findStationsByLine(line);
        stationsName.forEach(stationName -> stations.add(new Station(stationName)));
    }

    private static Stations findStationsByLine(Line line) {
        if (lineAndStations.get(line) == null) {
            lineAndStations.put(line, new Stations());
        }
        return lineAndStations.get(line);
    }

    public static Map<Line, Stations> get() {
        return lineAndStations;
    }

    public static void deleteLine(String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        lineAndStations.remove(line);
    }

    public static void addStations(String lineName, String stationName, int order) {
        Line line = LineRepository.findLineByName(lineName);
        Stations stations = findStationsByLine(line);

        stations.add(new Station(stationName), order);
    }

    public static void deleteSection(String lineName, String stationName) {
        Line line = LineRepository.findLineByName(lineName);
        Stations stations = findStationsByLine(line);

        stations.delete(stationName);
    }

    public static boolean isExistSection(String lineName, String stationName) {
        Line line = LineRepository.findLineByName(lineName);
        Stations stations = findStationsByLine(line);

        return stations.isExistStationName(stationName);
    }


    public static int findLineSize(String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        Stations stations = findStationsByLine(line);

        return stations.size();

    }
}
