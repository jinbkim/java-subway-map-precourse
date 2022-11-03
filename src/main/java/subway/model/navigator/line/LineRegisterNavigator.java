package subway.model.navigator.line;

import subway.model.navigator.AbstractNavigator;
import subway.view.InputView;

public class LineRegisterNavigator extends AbstractNavigator {

    @Override
    public void run() {
        InputView.requestRegisterLine();
    }
}
