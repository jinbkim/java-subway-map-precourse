package subway.model.line;

import java.util.List;

public class LineRepository {

    private static final Lines lines = new Lines();

    public static void add(Line line) {
        lines.add(line);
    }

    //    public static boolean deleteLineByName(String name) {
    //        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    //    }
    public static List<Line> get() {
        return lines.get();
    }
}
