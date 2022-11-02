package subway.controller;

import subway.view.InputView;

public class StationRegisterController extends AbstractController {

    @Override
    public void run() {
        InputView.requestRegisterStation();
    }
}
