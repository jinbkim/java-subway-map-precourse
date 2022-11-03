package subway.model.navigator.main;

import subway.model.navigator.AbstractNavigator;
import subway.view.OutputView;

public class MapPrintNavigator extends AbstractNavigator {

    @Override
    public void run() {
        MainScreenNavigator mainScreenNavigator = new MainScreenNavigator();

        OutputView.printSubwayMap();
        mainScreenNavigator.run();
    }
}
