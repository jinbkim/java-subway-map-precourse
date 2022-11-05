package subway.controller;

import subway.domain.DummyData;
import subway.service.MainScreenService;

public class SubwayController {

    public static void run() {
        DummyData.insert();
        MainScreenService.run();

        //        OutputView.printSubwayMap();
        //        OutputView.printStationList();
        //        OutputView.printLineList();
    }
}
