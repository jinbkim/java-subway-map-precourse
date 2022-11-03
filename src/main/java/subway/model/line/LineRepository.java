package subway.model.line;

import java.util.List;

public class LineRepository {

    private static final Lines lines = new Lines();

    public static void add(Line line) {
        lines.add(line);
    }

    public static boolean deleteLine(String lineName) {
        return lines.deleteLine(lineName);
    }

    public static void addSection(String lineName, String stationName, int order) {
        lines.addSection(lineName, stationName, order);
    }

    public static void deleteSection(String lineName, String stationName) {
        lines.deleteSection(lineName, stationName);
    }

    public static List<Line> get() {
        return lines.get();
    }

}
