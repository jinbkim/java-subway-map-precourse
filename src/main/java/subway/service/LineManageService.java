package subway.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.repository.LineRepository;
import subway.repository.SubwayMapRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManageService extends Service{

    private static final Map<String, Runnable> selectAndAction = new HashMap<>();

    static {
        selectAndAction.put(ONE, LineManageService::register);
        selectAndAction.put(TWO, LineManageService::delete);
        selectAndAction.put(THREE, LineManageService::lookUp);
        selectAndAction.put(UPPER_BACK, MainScreenService::run);
        selectAndAction.put(LOWER_BACK, MainScreenService::run);
    }

    public static void run() {
        String lineManageScreenSelect = InputView.requestLineManageScreenSelect();

        selectAndAction.get(lineManageScreenSelect)
            .run();
    }

    private static void register() {
        String line = InputView.requestRegisterLine();
        String firstStation = InputView.requestRegisterLineFirstStation();
        String lastStation = InputView.requestRegisterLineLastStation();

        LineRepository.add(line);
        SubwayMapRepository.addStations(line, List.of(firstStation, lastStation));
        OutputView.printRegisterLineComplete();
        MainScreenService.run();
    }

    private static void delete() {
        String line = InputView.requestDeleteLine();

        SubwayMapRepository.deleteLine(line);
        LineRepository.delete(line);
        OutputView.printDeleteLineComplete();
        MainScreenService.run();
    }

    private static void lookUp() {
        OutputView.printLineList();
        MainScreenService.run();

    }
}
