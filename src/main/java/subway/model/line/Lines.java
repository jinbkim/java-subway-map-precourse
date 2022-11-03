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

    public void addSection(String lineName, String stationName, int order) {
        Line line = lines.stream()
            .filter(l -> l.isSameName(lineName))
            .findFirst()
            .orElse(null);

        line.addStation(stationName, order);
    }

    public boolean delete(String name) {
        return lines.removeIf(line -> line.isSameName(name));
    }
}
