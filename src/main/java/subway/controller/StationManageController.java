package subway.controller;

import subway.view.InputView;

public class StationManageController extends AbstractController {

    @Override
    public void run() {
        String stationManageSelect = InputView.requestStationManageScreenSelect();
        Controller controller = StationManageFactory.of(stationManageSelect);

        controller.run();
    }
}
