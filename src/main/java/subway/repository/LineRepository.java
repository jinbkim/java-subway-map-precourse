package subway.repository;

import subway.domain.Line;
import subway.domain.Lines;

public class LineRepository {

    private static final Lines lines = new Lines();

    public static void add(Line line) {
        lines.add(line);
    }

    public static Line findLineByName(String lineName) {
        return lines.get()
            .stream()
            .filter(line -> line.isSameName(lineName))
            .findAny()
            .orElse(null);
    }
}
