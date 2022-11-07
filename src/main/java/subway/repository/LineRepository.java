package subway.repository;

import java.util.List;
import subway.domain.Line;
import subway.domain.Lines;

public class LineRepository {

    private static Lines lines = new Lines();

    public static void add(String lineName) {
        lines.add(new Line(lineName));
    }

    public static Line findLineByName(String lineName) {
        return lines.get()
                .stream()
                .filter(line -> line.isSameName(lineName))
                .findAny()
                .orElse(null);
    }

    public static List<Line> get() {
        return lines.get();
    }

    public static void delete(String lineName) {
        lines.delete(lineName);
    }

    public static boolean isExistLineName(String lineName) {
        return lines.isExistLineName(lineName);
    }

    public static void clear() {
        lines = new Lines();
    }
}
