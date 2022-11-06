package subway.controller;

import subway.domain.DummyData;
import subway.service.MainScreenService;

public class SubwayController {

    public void run() {
        DummyData.insert();
        MainScreenService mainScreenService = new MainScreenService();
        mainScreenService.run();
    }
}
