package subway.model.navigator.main;

import subway.model.navigator.Navigator;
import subway.view.InputView;

public class MainScreenNavigator implements Navigator {

    @Override
    public void run() {
        String mainMenuSelect = InputView.requestMainScreenSelect();
        Navigator navigator = MainScreenNavigationFactory.of(mainMenuSelect);

        navigator.run();
    }
}
