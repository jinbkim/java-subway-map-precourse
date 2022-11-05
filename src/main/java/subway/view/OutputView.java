package subway.view;

import java.util.stream.Collectors;
import subway.model.line.Line;
import subway.model.line.LineRepository;
import subway.model.station.Station;
import subway.model.station.StationRepository;
import subway.model.station.Stations;

public class OutputView {

    private static final String NEWLINE = "\n";
    private static final String SECTION_LINE = "---";
    private static final String MESSAGE_FROM = "## %s\n";
    private static final String INFO_MESSAGE_FORM = "[INFO] %s\n";
    private static final String ERROR_MESSAGE_FORM = "[ERROR] %s\n";
    private static final String MAIN_SCREEN = "메인 화면\n" + "1. 역 관리\n" + "2. 노선 관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료";
    private static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    private static final String STATION_MANAGE_SCREEN = "역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기";
    private static final String LINE_MANAGE_SCREEN = "노선 관리 화면\n" + "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기";
    private static final String SECTION_MANAGE_SCREEN = "구간 관리 화면\n" + "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기";
    private static final String SUBWAY_MAP = "지하철 노선도";
    private static final String REQUEST_REGISTER_STATION = "등록할 역 이름을 입력하세요.";
    private static final String REQUEST_DELETE_STATION = "삭제할 역 이름을 입력하세요.";
    private static final String STATION_LIST = "역 목록";
    private static final String REQUEST_REGISTER_LINE = "등록할 노선 이름을 입력하세요.";
    private static final String REQUEST_DELETE_LINE = "삭제할 노선 이름을 입력하세요.";
    private static final String LINE_LIST = "노선 목록";
    private static final String REQUEST_LINE = "노선을 입력하세요.";
    private static final String REQUEST_DELETE_SECTION_LINE = "삭제할 구간의 노선을 입력하세요.";
    private static final String REGISTER_STATION_COMPLETE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_COMPLETE = "지하철 역이 삭제되었습니다.";
    private static final String REQUEST_REGISTER_LINE_FIRST_STATION = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String REQUEST_REGISTER_LINE_LAST_STATION = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String REGISTER_LINE_COMPLETE = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_LINE_COMPLETE = "지하철 노선이 삭제되었습니다.";
    private static final String REQUEST_STATION = "역이름을 입력하세요.";
    private static final String REQUEST_ORDER = "순서를 입력하세요.";
    private static final String REQUEST_DELETE_SECTION_STATION = "삭제할 구간의 역을 입력하세요.";
    private static final String DELETE_SECTION_COMPLETE = "구간이 삭제되었습니다.";
    private static final String WRONG_INPUT = "잘못된 입력값 입니다.";

    public static void printInfoMessage(String message) {
        System.out.printf(INFO_MESSAGE_FORM, message);
    }

    public static void printMessage(String message) {
        System.out.printf(MESSAGE_FROM, message);
    }

    public static void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORM, message);
    }

    public static void printWrongInput() {
        System.out.println();
        printErrorMessage(WRONG_INPUT);
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

    public static void printLineManageScreen() {
        printMessage(LINE_MANAGE_SCREEN);
        System.out.println();
        printMessage(SELECT_FUNCTION);
    }

    public static void printSectionManageScreen() {
        System.out.println();
        printMessage(SECTION_MANAGE_SCREEN);
        printMessage(SELECT_FUNCTION);
    }

    public static void printSubwayMap() {
        System.out.println();
        printMessage(SUBWAY_MAP);
        LineRepository.get()
            .forEach(line -> System.out.print(lineToString(line)));
    }

    public static void printRequestRegisterStation() {
        System.out.println();
        printMessage(REQUEST_REGISTER_STATION);
    }

    public static void printRequestDeleteStation() {
        System.out.println();
        printMessage(REQUEST_DELETE_STATION);
    }

    public static void printStationList() {
        System.out.println();
        printMessage(STATION_LIST);
        StationRepository.get()
            .forEach(station -> System.out.print(stationToString(station)));
    }

    public static void printRequestLineRegister() {
        System.out.println();
        printMessage(REQUEST_REGISTER_LINE);
    }

    public static void printRequestLineDelete() {
        System.out.println();
        printMessage(REQUEST_DELETE_LINE);
    }

    public static void printLineList() {
        System.out.println();
        printMessage(LINE_LIST);
        LineRepository.get()
            .forEach(line -> printInfoMessage(line.getName()));
    }

    public static void printRequestRegisterSectionLine() {
        printMessage(REQUEST_LINE);
    }

    public static void printRequestDeleteSectionLine() {
        printMessage(REQUEST_DELETE_SECTION_LINE);
    }

    public static void printRegisterStationComplete() {
        System.out.println();
        printInfoMessage(REGISTER_STATION_COMPLETE);
    }

    public static void printDeleteStationComplete() {
        System.out.println();
        printInfoMessage(DELETE_STATION_COMPLETE);
    }

    public static void printRequestRegisterLineFirstStation() {
        System.out.println();
        printMessage(REQUEST_REGISTER_LINE_FIRST_STATION);
    }

    public static void printRequestRegisterLineLastStation() {
        System.out.println();
        printMessage(REQUEST_REGISTER_LINE_LAST_STATION);
    }

    public static void printRegisterLineComplete() {
        System.out.println();
        printInfoMessage(REGISTER_LINE_COMPLETE);
    }

    public static void printDeleteLineComplete() {
        System.out.println();
        System.out.println(DELETE_LINE_COMPLETE);
    }

    public static void printRequestRegisterSectionStation() {
        System.out.println();
        printMessage(REQUEST_STATION);
    }

    public static void printRequestRegisterSectionOrder() {
        System.out.println();
        printMessage(REQUEST_ORDER);
    }

    public static void printRequestDeleteSectionStation() {
        System.out.println();
        printMessage(REQUEST_DELETE_SECTION_STATION);
    }

    public static void printDeleteSectionComplete() {
        System.out.println();
        System.out.println(DELETE_SECTION_COMPLETE);
    }


    private static String lineToString(Line line) {
        String lineName = String.format(INFO_MESSAGE_FORM, line.getName());
        String sectionLine = String.format(INFO_MESSAGE_FORM, SECTION_LINE);

        return NEWLINE + lineName + sectionLine + stationsToString(line.getStations());
    }

    private static String stationsToString(Stations stations) {
        return stations.get()
            .stream()
            .map(OutputView::stationToString)
            .collect(Collectors.joining());
    }

    private static String stationToString(Station station) {
        return String.format(INFO_MESSAGE_FORM, station.getName());
    }

}
