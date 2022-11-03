package subway.model.navigator.station;

import subway.model.navigator.Navigator;
import subway.view.InputView;

public class StationRegisterNavigator implements Navigator {

    @Override
    public void run() {
        InputView.requestRegisterStation();
    }
}
