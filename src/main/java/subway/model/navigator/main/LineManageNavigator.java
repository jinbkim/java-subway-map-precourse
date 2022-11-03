package subway.model.navigator.main;

import subway.model.navigator.Navigator;
import subway.model.navigator.line.LineManageFactory;
import subway.view.InputView;

public class LineManageNavigator implements Navigator {

    @Override
    public void run() {
        String lineManageSelect = InputView.requestLineManageScreenSelect();
        Navigator navigator = LineManageFactory.of(lineManageSelect);

        navigator.run();
    }
}
