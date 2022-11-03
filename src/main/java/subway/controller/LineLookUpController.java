package subway.controller;

import subway.view.OutputView;

public class LineLookUpController extends AbstractController {

    @Override
    public void run() {
        Controller mainScreenController = new MainScreenController();

        OutputView.printLineList();
        mainScreenController.run();
    }
}
