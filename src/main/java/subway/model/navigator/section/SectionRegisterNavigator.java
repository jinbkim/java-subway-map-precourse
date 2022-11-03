package subway.model.navigator.section;

import subway.model.navigator.Navigator;
import subway.view.InputView;

public class SectionRegisterNavigator implements Navigator {

    @Override
    public void run() {
        InputView.requestLine();

    }
}
