package subway.service;

import java.util.HashMap;
import java.util.Map;
import subway.repository.SubwayMapRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionManageService {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String UPPER_BACK = "B";
    private static final String LOWER_BACK = "b";

    private static final Map<String, Runnable> selectAndAction = new HashMap<>();

    static {
        selectAndAction.put(ONE, SectionManageService::register);
        selectAndAction.put(TWO, SectionManageService::delete);
        selectAndAction.put(UPPER_BACK, MainScreenService::run);
        selectAndAction.put(LOWER_BACK, MainScreenService::run);
    }

    public static void run() {
        String sectionManageScreenSelect = InputView.requestSectionManageScreenSelect();

        selectAndAction.get(sectionManageScreenSelect)
            .run();
    }

    private static void register() {
        String line = InputView.requestRegisterSectionLine();
        String station = InputView.requestRegisterSectionStation();
        int order = InputView.requestRegisterSectionOrder();

        SubwayMapRepository.addStations(line, station, order);
        MainScreenService.run();
    }

    private static void delete() {
        String line = InputView.requestDeleteSectionLine();
        String station = InputView.requestDeleteSectionStation();

        SubwayMapRepository.deleteSection(line, station);
        OutputView.printDeleteSectionComplete();
        MainScreenService.run();
    }
}
