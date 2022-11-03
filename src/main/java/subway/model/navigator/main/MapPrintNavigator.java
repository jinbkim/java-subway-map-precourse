package subway.model.navigator.main;

import subway.model.navigator.Navigator;
import subway.view.OutputView;

public class MapPrintNavigator implements Navigator {

    @Override
    public void run() {
        MainScreenNavigator mainScreenNavigator = new MainScreenNavigator();

        OutputView.printSubwayMap();
        mainScreenNavigator.run();
    }
}
