package subway.controller;

import subway.view.InputView;

public class LineDeleteController extends AbstractController {

    @Override
    public void run() {
        InputView.requestDeleteLine();
    }
}
