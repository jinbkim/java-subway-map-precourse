package subway.view;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;
import subway.repository.StationRepository;
import subway.repository.SubwayMapRepository;

public class OutputView {

    private static final String NEWLINE = "\n";
    private static final String SECTION_LINE = "---";
    private static final String MESSAGE_FROM = "## %s\n";
    private static final String INFO_MESSAGE_FORM = "[INFO] %s\n";
    private static final String ERROR_MESSAGE_FORM = "[ERROR] %s\n";
    private static final String SUBWAY_MAP = "지하철 노선도";
    private static final String STATION_LIST = "역 목록";

    public static void printMessage(String message) {
        System.out.printf(MESSAGE_FROM, message);
    }

    public static void printInfoMessage(String message) {
        System.out.printf(INFO_MESSAGE_FORM, message);
    }

    public static void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORM, message);
    }

    public static void printSubwayMap() {
        System.out.println();
        printMessage(SUBWAY_MAP);
        SubwayMapRepository.get()
            .forEach(OutputView::printSubwayMap);
    }

    private static void printSubwayMap(Line line, Stations stations) {
        printInfoMessage(line.getName());
        printInfoMessage(SECTION_LINE);
        printStations(stations);
    }

    private static void printStations(Stations stations) {
        stations.get()
            .forEach(OutputView::printStation);
        System.out.println();
    }

    private static void printStation(Station station) {
        printInfoMessage(station.getName());
    }

    public static void printStationList() {
        System.out.println();
        printMessage(STATION_LIST);
        StationRepository.get()
            .forEach(OutputView::printStation);
    }
}
