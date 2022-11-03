package subway.model.navigator.section;

import subway.model.line.LineRepository;
import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionDeleteNavigator implements Navigator {

    @Override
    public void run() {
        Navigator mainScreenNavigator = new MainScreenNavigator();
        String line = InputView.requestDeleteSectionLine();
        String station = InputView.requestDeleteSectionStation();

        LineRepository.deleteSection(line, station);
        OutputView.printDeleteSectionComplete();
        mainScreenNavigator.run();
    }
}
