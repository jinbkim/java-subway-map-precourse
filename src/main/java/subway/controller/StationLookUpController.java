package subway.controller;

import subway.view.OutputView;

public class StationLookUpController extends AbstractController {

    @Override
    public void run() {
        Controller mainScreenController = new MainScreenController();

        OutputView.printStationList();
        mainScreenController.run();
    }
}
