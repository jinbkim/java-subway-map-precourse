package subway.model.navigator.main;

import subway.model.navigator.AbstractNavigator;
import subway.model.navigator.Navigator;
import subway.view.InputView;

public class MainScreenNavigator extends AbstractNavigator {

    public void run() {
        String mainMenuSelect = InputView.requestMainScreenSelect();
        Navigator navigator = MainScreenNavigationFactory.of(mainMenuSelect);
        navigator.run();
    }
}
