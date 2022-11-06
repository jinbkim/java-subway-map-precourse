package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.view.InputView;
import subway.view.OutputView;

public class MainScreenService extends Service {

    private final Map<String, Runnable> selectAndAction = new HashMap<>();
    private final StationManageService stationManageService = new StationManageService(this);
    private final LineManageService lineManageService = new LineManageService(this);
    private final SectionManageService sectionManageService = new SectionManageService(this);

    public MainScreenService() {
        selectAndAction.put(ONE, stationManageService::run);
        selectAndAction.put(TWO, lineManageService::run);
        selectAndAction.put(THREE, sectionManageService::run);
        selectAndAction.put(FOUR, this::lookUp);
        selectAndAction.put(UPPER_QUIT, this::quit);
        selectAndAction.put(LOWER_QUIT, this::quit);
    }

    @Override
    public void run() {
        String mainScreenSelect = InputView.requestMainScreenSelect();

        selectAndAction.get(mainScreenSelect)
                .run();
    }

    private void lookUp() {
        OutputView.printSubwayMap();
        run();
    }

    private void quit() {

    }
}
