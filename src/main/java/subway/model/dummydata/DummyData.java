package subway.model.dummydata;

import subway.model.Line;
import subway.model.LineRepository;

public class DummyData {

    public static void insert() {
        initLine();
    }

    private static void initLine() {
        DummyDataList.getLines()
            .forEach(line -> LineRepository.addLine(new Line(line)));
    }
}
