package subway.model.navigator.main;

import subway.model.navigator.Navigator;
import subway.view.InputView;

public class SectionManageNavigator implements Navigator {

    @Override
    public void run() {
        InputView.requestSectionManageScreenSelect();
    }
}
