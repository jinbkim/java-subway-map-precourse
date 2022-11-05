package subway.controller;

import subway.domain.DummyData;
import subway.view.OutputView;

public class SubwayController {

    public static void run() {
        DummyData.insert();
        OutputView.printSubwayMap();
        OutputView.printStationList();
        OutputView.printLineList();
    }
}
