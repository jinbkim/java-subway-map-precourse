package subway.controller;

import subway.view.InputView;

public class LineManageController extends AbstractController {

    @Override
    public void run() {
        String lineManageSelect = InputView.requestLineManageScreenSelect();
        Controller controller = LineManageFactory.of(lineManageSelect);

        controller.run();
    }
}
