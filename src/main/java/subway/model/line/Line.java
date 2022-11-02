package subway.model.line;

import java.util.List;
import subway.model.station.Stations;

public class Line {

    private String name;
    private Stations stations;

    public Line(String name, List<String> stations) {
        this.name = name;
        this.stations = new Stations(stations);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
