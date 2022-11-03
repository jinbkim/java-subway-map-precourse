package subway.controller;

import subway.view.InputView;

public class LineRegisterController extends AbstractController {

    @Override
    public void run() {
        InputView.requestRegisterLine();
    }
}
