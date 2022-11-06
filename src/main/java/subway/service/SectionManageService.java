package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.repository.SubwayMapRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionManageService extends Service {

    private final Map<String, Runnable> selectAndAction = new HashMap<>();
    private final MainScreenService mainScreenService;

    public SectionManageService(MainScreenService mainScreenService) {
        selectAndAction.put(ONE, this::register);
        selectAndAction.put(TWO, this::delete);
        selectAndAction.put(UPPER_BACK, mainScreenService::run);
        selectAndAction.put(LOWER_BACK, mainScreenService::run);
        this.mainScreenService = mainScreenService;
    }

    public void run() {
        String sectionManageScreenSelect = InputView.requestSectionManageScreenSelect();

        selectAndAction.get(sectionManageScreenSelect)
            .run();
    }

    private void register() {
        String line = InputView.requestRegisterSectionLine();
        String station = InputView.requestRegisterSectionStation();
        int order = InputView.requestRegisterSectionOrder();

        SubwayMapRepository.addStations(line, station, order);
        mainScreenService.run();
    }

    private void delete() {
        String line = InputView.requestDeleteSectionLine();
        String station = InputView.requestDeleteSectionStation();

        SubwayMapRepository.deleteSection(line, station);
        OutputView.printDeleteSectionComplete();
        mainScreenService.run();
    }
}
