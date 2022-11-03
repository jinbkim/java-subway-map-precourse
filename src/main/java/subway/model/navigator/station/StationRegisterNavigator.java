package subway.model.navigator.station;

import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;
import subway.model.station.Station;
import subway.model.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationRegisterNavigator implements Navigator {

    @Override
    public void run() {
        String registerStation = InputView.requestRegisterStation();
        Navigator mainScreenNavigator = new MainScreenNavigator();

        StationRepository.add(new Station(registerStation));
        OutputView.printRegisterStationComplete();
        mainScreenNavigator.run();
    }
}
