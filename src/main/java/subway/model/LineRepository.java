package subway.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String SHIN_BUN_DANG_LINE = "신분당선";
    private static final List<Line> lines = new ArrayList<>();

    public LineRepository() {
        addLine(new Line(LINE_TWO));
        addLine(new Line(LINE_THREE));
        addLine(new Line(SHIN_BUN_DANG_LINE));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
