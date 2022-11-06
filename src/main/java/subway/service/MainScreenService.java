package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.view.InputView;
import subway.view.OutputView;

public class MainScreenService {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String UPPER_QUIT = "Q";
    private static final String LOWER_QUIT = "q";

    private static final Map<String, Runnable> selectAndAction = new HashMap<>();

    static {
        selectAndAction.put(ONE, StationManageService::run);
        selectAndAction.put(TWO, LineManageService::run);
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
