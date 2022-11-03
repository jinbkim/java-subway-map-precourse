package subway.model.navigator.line;

import subway.model.line.Line;
import subway.model.line.LineRepository;
import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.view.InputView;
import subway.view.OutputView;

public class LineRegisterNavigator implements Navigator {

    @Override
    public void run() {
        MainScreenNavigator mainScreenNavigator = new MainScreenNavigator();
        String registerLine = InputView.requestRegisterLine();
        String firstStation = InputView.requestRegisterLineFirstStation();
        String lastStation = InputView.requestRegisterLineLastStation();

        LineRepository.add(new Line(registerLine, firstStation, lastStation));
        OutputView.printRegisterLineComplete();
        mainScreenNavigator.run();
    }
}
