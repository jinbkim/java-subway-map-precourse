package subway.model;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public void add(Line line) {
        lines.add(line);
    }
}
