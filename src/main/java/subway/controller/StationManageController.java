package subway.controller;

import subway.view.InputView;

public class StationManageController extends AbstractController {

    @Override
    public void run() {
        InputView.requestStationManageScreenSelect();
    }
}
