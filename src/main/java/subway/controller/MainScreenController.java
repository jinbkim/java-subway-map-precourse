package subway.controller;

import subway.view.InputView;

public class MainScreenController extends AbstractController {

    public void run() {
        String mainMenuSelect = InputView.requestMainScreenSelect();
        Controller controller = MainScreenNavigationFactory.of(mainMenuSelect);
        controller.run();
    }
}
