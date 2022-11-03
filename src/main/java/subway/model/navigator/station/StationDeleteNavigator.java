package subway.model.navigator.station;

import subway.model.navigator.AbstractNavigator;
import subway.view.InputView;

public class StationDeleteNavigator extends AbstractNavigator {

    @Override
    public void run() {
        InputView.requestDeleteStation();

    }
}
