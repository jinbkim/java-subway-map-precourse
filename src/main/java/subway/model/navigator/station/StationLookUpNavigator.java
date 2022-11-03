package subway.model.navigator.station;

import subway.model.navigator.AbstractNavigator;
import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.OutputView;

public class StationLookUpNavigator extends AbstractNavigator {

    @Override
    public void run() {
        Navigator mainScreenNavigator = new MainScreenNavigator();

        OutputView.printStationList();
        mainScreenNavigator.run();
    }
}
