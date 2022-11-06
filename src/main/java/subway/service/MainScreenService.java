package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.view.InputView;
import subway.view.OutputView;

public class MainScreenService extends Service{

    private static final Map<String, Runnable> selectAndAction = new HashMap<>();

    static {
        selectAndAction.put(ONE, StationManageService::run);
        selectAndAction.put(TWO, LineManageService::run);
        selectAndAction.put(THREE, SectionManageService::run);
        selectAndAction.put(FOUR, MainScreenService::lookUp);
    }

    public static void run() {
        String mainScreenSelect = InputView.requestMainScreenSelect();

        selectAndAction.get(mainScreenSelect)
            .run();
    }

    private static void lookUp() {
        OutputView.printSubwayMap();
        run();
    }
}
