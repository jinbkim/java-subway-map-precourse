package subway.model.navigator.line;

import subway.model.navigator.Navigator;
import subway.view.InputView;

public class LineRegisterNavigator implements Navigator {

    @Override
    public void run() {
        InputView.requestRegisterLine();
    }
}
