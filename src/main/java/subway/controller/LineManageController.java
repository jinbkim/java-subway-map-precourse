package subway.controller;

import subway.view.InputView;

public class LineManageController extends AbstractController {

    @Override
    public void run() {
        InputView.requestLineManageScreenSelect();
    }
}
