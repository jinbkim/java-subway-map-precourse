package subway.model.navigator.line;

import subway.model.navigator.AbstractNavigator;
import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.OutputView;

public class LineLookUpNavigator extends AbstractNavigator {

    @Override
    public void run() {
        Navigator mainScreenNavigator = new MainScreenNavigator();

        OutputView.printLineList();
        mainScreenNavigator.run();
    }
}
