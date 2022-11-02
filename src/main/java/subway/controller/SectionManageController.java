package subway.controller;

import subway.view.InputView;

public class SectionManageController extends AbstractController {

    @Override
    public void run() {
        InputView.requestSectionManageScreenSelect();
    }
}
