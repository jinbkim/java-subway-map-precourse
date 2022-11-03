package subway.model.navigator.main;

import subway.model.navigator.Navigator;
import subway.model.navigator.station.StationManageFactory;
import subway.view.InputView;

public class StationManageNavigator implements Navigator {

    @Override
    public void run() {
        String stationManageSelect = InputView.requestStationManageScreenSelect();
        Navigator navigator = StationManageFactory.of(stationManageSelect);

        navigator.run();
    }
}
