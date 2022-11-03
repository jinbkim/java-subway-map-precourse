package subway.model.navigator.main;

import subway.model.navigator.AbstractNavigator;
import subway.model.navigator.Navigator;
import subway.model.navigator.line.LineManageFactory;
import subway.view.InputView;

public class LineManageNavigator extends AbstractNavigator {

    @Override
    public void run() {
        String lineManageSelect = InputView.requestLineManageScreenSelect();
        Navigator navigator = LineManageFactory.of(lineManageSelect);

        navigator.run();
    }
}
