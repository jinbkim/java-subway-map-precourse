package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private List<Line> lines = new ArrayList<>();

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> get() {
        return lines;
    }

    public void delete(String lineName) {
        lines = lines.stream()
                .filter(line -> !line.isSameName(lineName))
                .collect(Collectors.toList());
    }

    public boolean isExist(String lineName) {
        return lines.stream()
                .anyMatch(line -> line.isSameName(lineName));
    }
}
