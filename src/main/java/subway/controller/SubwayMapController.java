package subway.controller;

import subway.model.DummyData;
import subway.model.navigator.main.MainScreenNavigator;

public class SubwayMapController {

    public void run() {
        MainScreenNavigator mainScreenNavigator = new MainScreenNavigator();

        DummyData.insert();
        mainScreenNavigator.run();
    }
}
