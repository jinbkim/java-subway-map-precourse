package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManageService {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String UPPER_BACK = "B";
    private static final String LOWER_BACK = "b";

    private static final Map<String, Runnable> selectAndAction = new HashMap<>();

    static {
        selectAndAction.put(ONE, StationManageService::register);
        selectAndAction.put(TWO, StationManageService::delete);
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
}
