package subway.controller;

import subway.view.OutputView;

public class MapPrintController extends AbstractController {

    @Override
    public void run() {
        MainScreenController mainScreenController = new MainScreenController();

        OutputView.printSubwayMap();
        mainScreenController.run();
    }
}
