package subway.model.navigator.line;

import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.OutputView;

public class LineLookUpNavigator implements Navigator {

    @Override
    public void run() {
        Navigator mainScreenNavigator = new MainScreenNavigator();

        OutputView.printLineList();
        mainScreenNavigator.run();
    }
}
