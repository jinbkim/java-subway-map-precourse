package subway.model.navigator.main;

import subway.model.navigator.Navigator;
import subway.model.navigator.section.SectionManageFactory;
import subway.view.InputView;

public class SectionManageNavigator implements Navigator {

    @Override
    public void run() {
        String sectionManageSelect = InputView.requestSectionManageScreenSelect();
        Navigator navigator = SectionManageFactory.of(sectionManageSelect);

        navigator.run();
    }
}
