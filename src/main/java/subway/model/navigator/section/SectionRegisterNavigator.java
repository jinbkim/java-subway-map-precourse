package subway.model.navigator.section;

import subway.model.line.LineRepository;
import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.InputView;

public class SectionRegisterNavigator implements Navigator {

    @Override
    public void run() {
        Navigator mainScreenNavigator = new MainScreenNavigator();
        String line = InputView.requestLine();
        String station = InputView.requestStation();
        int order = InputView.requestOrder();

        LineRepository.addSection(line, station, order);
        mainScreenNavigator.run();
    }
}
