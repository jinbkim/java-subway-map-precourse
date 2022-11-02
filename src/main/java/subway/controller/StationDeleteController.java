package subway.controller;

import subway.view.InputView;

public class StationDeleteController extends AbstractController {

    @Override
    public void run() {
        InputView.requestDeleteStation();

    }
}
