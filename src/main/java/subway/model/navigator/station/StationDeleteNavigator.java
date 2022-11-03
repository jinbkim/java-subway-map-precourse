package subway.model.navigator.station;

import subway.model.navigator.Navigator;
import subway.view.InputView;

public class StationDeleteNavigator implements Navigator {

    @Override
    public void run() {
        InputView.requestDeleteStation();

    }
}
