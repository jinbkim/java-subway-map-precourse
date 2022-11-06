package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManageService extends Service{

    private static final Map<String, Runnable> selectAndAction = new HashMap<>();

    static {
        selectAndAction.put(ONE, StationManageService::register);
        selectAndAction.put(TWO, StationManageService::delete);
        selectAndAction.put(THREE, StationManageService::lookUp);
        selectAndAction.put(UPPER_BACK, MainScreenService::run);
        selectAndAction.put(LOWER_BACK, MainScreenService::run);
    }

    public static void run() {
        String stationManageScreenSelect = InputView.requestStationManageScreenSelect();

        selectAndAction.get(stationManageScreenSelect)
            .run();
    }

    private static void register() {
        String station = InputView.requestRegisterStation();

        StationRepository.add(station);
        OutputView.printRegisterStationComplete();
        MainScreenService.run();
    }

    private static void delete() {
        String station = InputView.requestDeleteStation();

        StationRepository.delete(station);
        OutputView.printDeleteStationComplete();
        MainScreenService.run();
    }

    private static void lookUp() {
        OutputView.printStationList();
        MainScreenService.run();
    }
}
