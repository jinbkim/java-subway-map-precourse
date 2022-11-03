package subway.model.navigator.station;

import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.model.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationDeleteNavigator implements Navigator {

    @Override
    public void run() {
        String deleteStation = InputView.requestDeleteStation();
        Navigator mainScreenNavigator = new MainScreenNavigator();

        StationRepository.delete(deleteStation);
        OutputView.printDeleteStationComplete();
        mainScreenNavigator.run();
    }
}
