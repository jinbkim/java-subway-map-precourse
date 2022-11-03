package subway.model.navigator.station;

import subway.model.navigator.AbstractNavigator;
import subway.view.InputView;

public class StationRegisterNavigator extends AbstractNavigator {

    @Override
    public void run() {
        InputView.requestRegisterStation();
    }
}
