package subway.model.navigator.line;

import subway.model.navigator.Navigator;
import subway.view.InputView;

public class LineDeleteNavigator implements Navigator {

    @Override
    public void run() {
        InputView.requestDeleteLine();
    }
}
