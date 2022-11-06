package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManageService extends Service {

    private final Map<String, Runnable> selectAndAction = new HashMap<>();
    private final MainScreenService mainScreenService;

    public StationManageService(MainScreenService mainScreenService) {
        selectAndAction.put(ONE, this::register);
        selectAndAction.put(TWO, this::delete);
        selectAndAction.put(THREE, this::lookUp);
        selectAndAction.put(UPPER_BACK, mainScreenService::run);
        selectAndAction.put(LOWER_BACK, mainScreenService::run);
        this.mainScreenService = mainScreenService;
    }

    public void run() {
        String stationManageScreenSelect = InputView.requestStationManageScreenSelect();

        selectAndAction.get(stationManageScreenSelect)
            .run();
    }

    private void register() {
        String station = InputView.requestRegisterStation();

        StationRepository.add(station);
        OutputView.printRegisterStationComplete();
        mainScreenService.run();
    }

    private void delete() {
        String station = InputView.requestDeleteStation();

        StationRepository.delete(station);
        OutputView.printDeleteStationComplete();
        mainScreenService.run();
    }

    private void lookUp() {
        OutputView.printStationList();
        mainScreenService.run();
    }
}
