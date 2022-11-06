package subway.view;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.repository.SubwayMapRepository;

public class OutputView {

    private static final String SECTION_LINE = "---";
    private static final String MESSAGE_FROM = "## %s\n";
    private static final String INFO_MESSAGE_FORM = "[INFO] %s\n";
    private static final String ERROR_MESSAGE_FORM = "[ERROR] %s\n";
    private static final String SUBWAY_MAP = "지하철 노선도";
    private static final String STATION_LIST = "역 목록";
    private static final String LINE_LIST = "노선 목록";
    private static final String MAIN_SCREEN = "메인 화면\n" + "1. 역 관리\n" + "2. 노선 관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료";
    private static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    private static final String STATION_MANAGE_SCREEN = "역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기";
    private static final String REQUEST_REGISTER_STATION = "등록할 역 이름을 입력하세요.";
    private static final String REGISTER_STATION_COMPLETE = "지하철 역이 등록되었습니다.";
    private static final String REQUEST_DELETE_STATION = "삭제할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_COMPLETE = "지하철 역이 삭제되었습니다.";

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

    public static void printLineList() {
        System.out.println();
        printMessage(LINE_LIST);
        LineRepository.get()
            .forEach(line -> printInfoMessage(line.getName()));
    }

    public static void printMainScreen() {
        System.out.println();
        printMessage(MAIN_SCREEN);
        System.out.println();
        printMessage(SELECT_FUNCTION);
    }

    public static void printStationManageScreen() {
        System.out.println();
        printMessage(STATION_MANAGE_SCREEN);
        System.out.println();
        printMessage(SELECT_FUNCTION);
    }

    public static void printRequestRegisterStation() {
        System.out.println();
        printMessage(REQUEST_REGISTER_STATION);
    }

    public static void printRegisterStationComplete() {
        System.out.println();
        printInfoMessage(REGISTER_STATION_COMPLETE);
    }

    public static void printRequestDeleteStation() {
        System.out.println();
        printMessage(REQUEST_DELETE_STATION);
    }

    public static void printDeleteStationComplete() {
        System.out.println();
        printInfoMessage(DELETE_STATION_COMPLETE);
    }
}
