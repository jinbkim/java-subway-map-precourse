package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private List<Line> lines = new ArrayList<>();

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> get() {
        return lines;
    }
}
