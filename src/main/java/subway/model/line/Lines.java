package subway.model.line;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> get() {
        return lines;
    }

    public void deleteStation(String stationName) {
        lines.forEach(line -> line.deleteStation(stationName));
    }

    public void deleteLine(String name) {
        lines.removeIf(line -> line.isSameName(name));
    }

    public void addSection(String lineName, String stationName, int order) {
        Line line = findLineByName(lineName);

        line.addStation(stationName, order);
    }

    public void deleteSection(String lineName, String stationName) {
        Line line = findLineByName(lineName);

        line.deleteStation(stationName);
    }

    public Line findLineByName(String lineName) {
        return lines.stream()
            .filter(l -> l.isSameName(lineName))
            .findFirst()
            .orElse(null);
    }

    public boolean isExist(String lineName) {
        return lines.stream()
            .anyMatch(line -> line.isSameName(lineName));
    }
}
