package subway.model.navigator.section;

import subway.model.line.LineRepository;
import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.InputView;

public class SectionRegisterNavigator implements Navigator {

    @Override
    public void run() {
        Navigator mainScreenNavigator = new MainScreenNavigator();
        String line = InputView.requestRegisterSectionLine();
        String station = InputView.requestRegisterSectionStation();
        int order = InputView.requestRegisterSectionOrder(line);

        LineRepository.addSection(line, station, order);
        mainScreenNavigator.run();
    }
}
