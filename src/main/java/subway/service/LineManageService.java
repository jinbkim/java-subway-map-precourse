package subway.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.repository.LineRepository;
import subway.repository.SubwayMapRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManageService extends Service {

    private final Map<String, Runnable> selectAndAction = new HashMap<>();
    private final MainScreenService mainScreenService;

    public LineManageService(MainScreenService mainScreenService) {
        selectAndAction.put(ONE, this::register);
        selectAndAction.put(TWO, this::delete);
        selectAndAction.put(THREE, this::lookUp);
        selectAndAction.put(UPPER_BACK, mainScreenService::run);
        selectAndAction.put(LOWER_BACK, mainScreenService::run);
        this.mainScreenService = mainScreenService;
    }

    public void run() {
        String lineManageScreenSelect = InputView.requestLineManageScreenSelect();

        selectAndAction.get(lineManageScreenSelect)
            .run();
    }

    private void register() {
        String line = InputView.requestRegisterLine();
        String firstStation = InputView.requestRegisterLineFirstStation();
        String lastStation = InputView.requestRegisterLineLastStation();

        LineRepository.add(line);
        SubwayMapRepository.addStations(line, List.of(firstStation, lastStation));
        OutputView.printRegisterLineComplete();
        mainScreenService.run();
    }

    private void delete() {
        String line = InputView.requestDeleteLine();

        SubwayMapRepository.deleteLine(line);
        LineRepository.delete(line);
        OutputView.printDeleteLineComplete();
        mainScreenService.run();
    }

    private void lookUp() {
        OutputView.printLineList();
        mainScreenService.run();

    }
}
