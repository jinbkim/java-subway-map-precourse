package subway;

import subway.controller.SubwayMapController;

public class Application {

    public static void main(String[] args) {
        SubwayMapController subwayController = new SubwayMapController();
        subwayController.run();
    }
}
