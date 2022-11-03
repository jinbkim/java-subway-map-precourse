package subway.model.navigator.line;

import subway.model.line.LineRepository;
import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.InputView;
import subway.view.OutputView;

public class LineDeleteNavigator implements Navigator {

    @Override
    public void run() {
        Navigator mainScreenNavigator = new MainScreenNavigator();
        String deleteLine = InputView.requestDeleteLine();

        LineRepository.delete(deleteLine);
        OutputView.printDeleteLineComplete();
        mainScreenNavigator.run();
    }
}
