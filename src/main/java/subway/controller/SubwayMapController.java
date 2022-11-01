package subway.controller;

import subway.model.DummyData;
import subway.view.InputView;

public class SubwayMapController {

    public static void run() {
        DummyData.insert();
        String mainMenuSelect = InputView.requestMainMenuSelect();
    }
}
