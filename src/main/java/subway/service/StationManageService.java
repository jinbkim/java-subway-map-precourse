package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManageService extends ManageService {

    private final Map<String, Runnable> selectAndAction = new HashMap<>();
    private final MainScreenService mainScreenService;

    public StationManageService(MainScreenService mainScreenService) {
        selectAndAction.put(ONE, this::register);
        selectAndAction.put(TWO, this::delete);
        selectAndAction.put(THREE, OutputView::printStationList);
        selectAndAction.put(UPPER_BACK, mainScreenService::run);
        selectAndAction.put(LOWER_BACK, mainScreenService::run);
        this.mainScreenService = mainScreenService;
    }

    @Override
    public void run() {
        String stationManageScreenSelect = InputView.requestStationManageScreenSelect();

        selectAndAction.get(stationManageScreenSelect)
            .run();
        mainScreenService.run();
    }

    @Override
    protected void register() {
        String station = InputView.requestRegisterStation();

        StationRepository.add(station);
        OutputView.printRegisterStationComplete();
    }

    @Override
    protected void delete() {
        String station = InputView.requestDeleteStation();

        StationRepository.delete(station);
        OutputView.printDeleteStationComplete();
    }
}
