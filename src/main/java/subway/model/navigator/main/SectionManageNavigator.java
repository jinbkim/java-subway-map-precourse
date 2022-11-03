package subway.model.navigator.main;

import subway.model.navigator.AbstractNavigator;
import subway.view.InputView;

public class SectionManageNavigator extends AbstractNavigator {

    @Override
    public void run() {
        InputView.requestSectionManageScreenSelect();
    }
}
