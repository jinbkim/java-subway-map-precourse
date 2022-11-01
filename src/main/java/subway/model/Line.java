package subway.model;

public class Line {

    private String name;
    private StationRepository stationRepository;

    public Line(String name, StationRepository stationRepository) {
        this.name = name;
        this.stationRepository = stationRepository;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
