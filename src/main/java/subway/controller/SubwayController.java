package subway.controller;

import subway.model.DummyData;

public class SubwayController extends AbstractController {

    public void run() {
        DummyData.insert();
        MainScreenController mainScreenController = new MainScreenController();
        mainScreenController.run();
    }
}
