package subway.view;

import java.util.Scanner;
import java.util.regex.Pattern;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.repository.SubwayMapRepository;
import subway.utis.Utils;

public class InputView {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final String MAIN_SCREEN_SELECT_REGEX = "^[1234qQ]$";
    private static final String STATION_MANAGE_SCREEN_SELECT_REGEX = "^[123bB]$";
    private static final String LINE_MANAGE_SCREEN_SELECT_REGEX = "^[123bB]$";
    private static final String SECTION_MANAGE_SCREEN_SELECT_REGEX = "^[12bB]$";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    private static final String STATION_REGEX = "^.{2,}$";
    private static final String LINE_REGEX = "^.{2,}$";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String requestMainScreenSelect() {
        OutputView.printMainScreen();
        try {
            return validateMainScreenSelect(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestMainScreenSelect();
        }
    }

    static String validateMainScreenSelect(String mainScreenSelect) {
        mainScreenSelect = Utils.deleteAllSpace(mainScreenSelect);
        if (!Pattern.matches(MAIN_SCREEN_SELECT_REGEX, mainScreenSelect)) {
            throw new IllegalArgumentException();
        }
        return mainScreenSelect;
    }

    public static String requestStationManageScreenSelect() {
        OutputView.printStationManageScreen();
        try {
            return validateStationManageScreenSelect(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestStationManageScreenSelect();
        }
    }

    static String validateStationManageScreenSelect(String stationManageScreenSelect) {
        stationManageScreenSelect = Utils.deleteAllSpace(stationManageScreenSelect);
        if (!Pattern.matches(STATION_MANAGE_SCREEN_SELECT_REGEX, stationManageScreenSelect)) {
            throw new IllegalArgumentException();
        }
        return stationManageScreenSelect;
    }

    public static String requestRegisterStation() {
        OutputView.printRequestRegisterStation();
        try {
            return validateRegisterStation(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterStation();
        }
    }

    static String validateRegisterStation(String registerStationInput) {
        registerStationInput = Utils.deleteAllSpace(registerStationInput);
        if (!Pattern.matches(STATION_REGEX, registerStationInput) || isExistStation(registerStationInput)) {
            throw new IllegalArgumentException();
        }
        return registerStationInput;
    }

    private static boolean isExistStation(String stationName) {
        return StationRepository.isExist(stationName);
    }

    public static String requestDeleteStation() {
        OutputView.printRequestDeleteStation();
        try {
            return validateIsExistStation(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestDeleteStation();
        }
    }

    static String validateIsExistStation(String stationName) {
        stationName = Utils.deleteAllSpace(stationName);
        if (!StationRepository.isExist(stationName)) {
            throw new IllegalArgumentException();
        }
        return stationName;
    }

    public static String requestLineManageScreenSelect() {
        OutputView.printLineManageScreen();
        try {
            return validateLineManageScreenSelect(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestLineManageScreenSelect();
        }
    }

    static String validateLineManageScreenSelect(String lineManageScreenSelect) {
        lineManageScreenSelect = Utils.deleteAllSpace(lineManageScreenSelect);
        if (!Pattern.matches(LINE_MANAGE_SCREEN_SELECT_REGEX, lineManageScreenSelect)) {
            throw new IllegalArgumentException();
        }
        return lineManageScreenSelect;
    }

    public static String requestRegisterLine() {
        OutputView.printRequestLineRegister();
        try {
            return validateRegisterLine(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterLine();
        }
    }

    static String validateRegisterLine(String registerLineInput) {
        registerLineInput = Utils.deleteAllSpace(registerLineInput);
        if (!Pattern.matches(LINE_REGEX, registerLineInput) || isExistLine(registerLineInput)) {
            throw new IllegalArgumentException();
        }
        return registerLineInput;
    }

    private static boolean isExistLine(String lineName) {
        return LineRepository.isExist(lineName);
    }

    public static String requestRegisterLineFirstStation() {
        OutputView.printRequestRegisterLineFirstStation();
        try {
            return validateRegisterLineFirstStation(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterLineFirstStation();
        }
    }

    static String validateRegisterLineFirstStation(String firstStation) {
        firstStation = Utils.deleteAllSpace(firstStation);
        if (!StationRepository.isExist(firstStation)) {
            throw new IllegalArgumentException();
        }
        return firstStation;
    }

    public static String requestRegisterLineLastStation(String firstStation) {
        OutputView.printRequestRegisterLineLastStation();
        try {
            return validateRegisterLineLastStation(SCANNER.nextLine(), firstStation);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterLineLastStation(firstStation);
        }
    }

    static String validateRegisterLineLastStation(String lastStation, String firstStation) {
        lastStation = Utils.deleteAllSpace(lastStation);
        firstStation = Utils.deleteAllSpace(firstStation);
        if (lastStation.equals(firstStation) || !StationRepository.isExist(lastStation)) {
            throw new IllegalArgumentException();
        }
        return lastStation;
    }

    public static String requestDeleteLine() {
        OutputView.printRequestLineDelete();
        try {
            return validateIsExistLine(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestDeleteLine();
        }
    }

    static String validateIsExistLine(String lineName) {
        lineName = Utils.deleteAllSpace(lineName);
        if (!LineRepository.isExist(lineName)) {
            throw new IllegalArgumentException();
        }
        return lineName;
    }

    public static String requestSectionManageScreenSelect() {
        OutputView.printSectionManageScreen();
        try {
            return validateSectionManageScreenSelect(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestSectionManageScreenSelect();
        }
    }

    static String validateSectionManageScreenSelect(String sectionManageScreenSelect) {
        sectionManageScreenSelect = Utils.deleteAllSpace(sectionManageScreenSelect);
        if (!Pattern.matches(SECTION_MANAGE_SCREEN_SELECT_REGEX, sectionManageScreenSelect)) {
            throw new IllegalArgumentException();
        }
        return sectionManageScreenSelect;
    }

    public static String requestRegisterSectionLine() {
        OutputView.printRequestRegisterSectionLine();
        try {
            return validateIsExistLine(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterSectionLine();
        }
    }

    public static String requestRegisterSectionStation(String lineName) {
        OutputView.printRequestRegisterSectionStation();
        try {
            return validateRegisterSectionStation(SCANNER.nextLine(), lineName);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterSectionStation(lineName);
        }
    }

    public static String validateRegisterSectionStation(String stationName, String lineName) {
        stationName = Utils.deleteAllSpace(stationName);
        if (SubwayMapRepository.isExistSection(lineName, stationName) || !StationRepository.isExist(stationName)) {
            throw new IllegalArgumentException();
        }
        return validateIsExistStation(stationName);
    }

    public static int requestRegisterSectionOrder(String lineName) {
        OutputView.printRequestRegisterSectionOrder();
        try {
            return validateRegisterSectionOrder(SCANNER.nextLine(), lineName);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterSectionOrder(lineName);
        }
    }

    static int validateRegisterSectionOrder(String orderInput, String lineName) {
        orderInput = Utils.deleteAllSpace(orderInput);
        lineName = Utils.deleteAllSpace(lineName);
        if (!Pattern.matches(ONLY_NUMBER_REGEX, orderInput)) {
            throw new IllegalArgumentException();
        }
        int order = Integer.parseInt(orderInput) - ONE;

        if (isInvalidSectionStationOrderRange(lineName, order)) {
            throw new IllegalArgumentException();
        }
        return order;
    }

    private static boolean isInvalidSectionStationOrderRange(String lineName, int order) {
        return order > SubwayMapRepository.findLineSize(lineName);

    }

    public static String requestDeleteSectionLine() {
        OutputView.printRequestDeleteSectionLine();
        try {
            return validateDeleteSectionLine(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestDeleteSectionLine();
        }
    }

    static String validateDeleteSectionLine(String lineName) {
        lineName = Utils.deleteAllSpace(lineName);
        if (!LineRepository.isExist(lineName) || isInvalidSectionLineSize(lineName)) {
            throw new IllegalArgumentException();
        }
        return lineName;
    }

    private static boolean isInvalidSectionLineSize(String lineName) {
        return SubwayMapRepository.findLineSize(lineName) <= TWO;
    }

    public static String requestDeleteSectionStation() {
        OutputView.printRequestDeleteSectionStation();
        try {
            return validateIsExistStation(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestDeleteSectionStation();
        }
    }
}
