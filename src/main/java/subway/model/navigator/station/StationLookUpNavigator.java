package subway.model.navigator.station;

import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.OutputView;

public class StationLookUpNavigator implements Navigator {

    @Override
    public void run() {
        Navigator mainScreenNavigator = new MainScreenNavigator();

        OutputView.printStationList();
        mainScreenNavigator.run();
    }
}
