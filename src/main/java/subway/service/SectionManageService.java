package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.repository.SubwayMapRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionManageService extends ManageService {

    private final Map<String, Runnable> selectAndAction = new HashMap<>();
    private final MainScreenService mainScreenService;

    public SectionManageService(MainScreenService mainScreenService) {
        selectAndAction.put(ONE, this::register);
        selectAndAction.put(TWO, this::delete);
        selectAndAction.put(UPPER_BACK, mainScreenService::run);
        selectAndAction.put(LOWER_BACK, mainScreenService::run);
        this.mainScreenService = mainScreenService;
    }

    @Override
    public void run() {
        String sectionManageScreenSelect = InputView.requestSectionManageScreenSelect();

        selectAndAction.get(sectionManageScreenSelect)
            .run();
        mainScreenService.run();
    }

    @Override
    protected void register() {
        String line = InputView.requestRegisterSectionLine();
        String station = InputView.requestRegisterSectionStation();
        int order = InputView.requestRegisterSectionOrder();

        SubwayMapRepository.addStations(line, station, order);
        OutputView.printRegisterSectionComplete();
    }

    @Override
    protected void delete() {
        String line = InputView.requestDeleteSectionLine();
        String station = InputView.requestDeleteSectionStation();

        SubwayMapRepository.deleteSection(line, station);
        OutputView.printDeleteSectionComplete();
    }
}
