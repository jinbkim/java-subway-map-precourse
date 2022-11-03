package subway.model.line;

import java.util.List;

public class LineRepository {

    private static final Lines lines = new Lines();

    public static void add(Line line) {
        lines.add(line);
    }

    public static boolean delete(String name) {
        return lines.delete(name);
    }

    public static List<Line> get() {
        return lines.get();
    }
}
