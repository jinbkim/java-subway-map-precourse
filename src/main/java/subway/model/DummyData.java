package subway.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import subway.model.line.Line;
import subway.model.line.LineRepository;
import subway.model.station.Station;
import subway.model.station.StationRepository;

public enum DummyData {
    TWO("2호선", Arrays.asList("교대역", "강남역", "역삼역")), THREE("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")), SHIN_BUN_DANG("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));

    private String line;
    private List<String> stations;

    DummyData(String line, List<String> stations) {
        this.line = line;
        this.stations = stations;
    }

    public static void insert() {
        Map<String, List<String>> lineAndStations = getAllDummyData();

        lineAndStations.forEach((line, stations) -> {
            stations.forEach(station -> StationRepository.add(new Station(station)));
            LineRepository.add(new Line(line, stations));
        });
    }

    private static Map<String, List<String>> getAllDummyData() {
        return Arrays.stream(values())
            .collect(Collectors.toMap(data -> data.line, data -> data.stations));
    }
}
