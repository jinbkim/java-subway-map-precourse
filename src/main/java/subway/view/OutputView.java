package subway.view;

import java.util.stream.Collectors;
import subway.model.line.Line;
import subway.model.line.LineRepository;
import subway.model.station.Station;
import subway.model.station.Stations;

public class OutputView {

    private static final String MAIN_SCREEN = "## 메인 화면\n" + "1. 역 관리\n" + "2. 노선 관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료";
    private static final String SELECT_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    private static final String STATION_MANAGE_SCREEN = "## 역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기";
    private static final String LINE_MANAGE_SCREEN = "## 노선 관리 화면\n" + "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기";
    private static final String SECTION_MANAGE_SCREEN = "## 구간 관리 화면\n" + "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기";
    private static final String SUBWAY_MAP = "## 지하철 노선도";
    private static final String SECTION_LINE = "---";
    private static final String INFO_MESSAGE_FORM = "[INFO] %s\n";

    //    private static final String REQUEST_REGISTER_STATION = "## 등록할 역 이름을 입력하세요.";
    //    private static final String REGISTER_STATION = "지하철 역이 등록되었습니다.";

    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN);
        System.out.println(SELECT_FUNCTION);
    }

    public static void printStationManageScreen() {
        System.out.println(STATION_MANAGE_SCREEN);
        System.out.println(SELECT_FUNCTION);
    }

    public static void printLineManageScreen() {
        System.out.println(LINE_MANAGE_SCREEN);
        System.out.println(SELECT_FUNCTION);
    }

    public static void printSectionManageScreen() {
        System.out.println(SECTION_MANAGE_SCREEN);
        System.out.println(SELECT_FUNCTION);
    }

    public static void printSubwayMap() {
        System.out.println(SUBWAY_MAP);
        LineRepository.get()
            .get()
            .forEach(line -> System.out.println(lineToString(line)));
    }

    private static String lineToString(Line line) {
        String lineName = String.format(INFO_MESSAGE_FORM, line.getName());
        String sectionLine = String.format(INFO_MESSAGE_FORM, SECTION_LINE);

        return lineName + sectionLine + stationsToString(line.getStations());
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

    //    public static void printRequestRegisterStation() {
    //        System.out.println();
    //        System.out.println(REQUEST_REGISTER_STATION);
    //    }
    //
    //
    //    public static void printRegisterStation() {
    //        System.out.println();
    //        System.out.println(INFO + REGISTER_STATION);
    //    }
}
