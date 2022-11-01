package subway.model.dummydata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DummyDataList {
    TWO("2호선", Arrays.asList("교대역", "강남역", "역삼역")), THREE("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")), SHIN_BUN_DANG("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));

    private String name;
    private List<String> stations;

    DummyDataList(String name, List<String> stations) {
        this.name = name;
        this.stations = stations;
    }

    public static List<String> getLines() {
        return Arrays.stream(values())
            .map(data -> data.name)
            .collect(Collectors.toList());
    }

}
