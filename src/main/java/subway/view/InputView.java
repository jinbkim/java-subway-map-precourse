package subway.view;

import java.util.Scanner;
import java.util.regex.Pattern;
import subway.model.line.LineRepository;
import subway.model.station.StationRepository;
import subway.utils.Utils;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int ONE = 1;
    private static final String MAIN_SCREEN_SELECT_REGEX = "^[1234qQ]$";
    private static final String STATION_MANAGE_SCREEN_SELECT_REGEX = "^[123bB]$";
    private static final String LINE_MANAGE_SCREEN_SELECT_REGEX = "^[123bB]$";
    private static final String SECTION_MANAGE_SCREEN_SELECT_REGEX = "^[12bB]$";
    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    private static final String STATION_REGEX = "^.{2,}$";
    private static final String LINE_REGEX = "^.{2,}$";

    public static String requestMainScreenSelect() {
        OutputView.printMainScreen();
        try {
            return validateMainScreenSelect(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestMainScreenSelect();
        }
    }

    static String validateMainScreenSelect(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(MAIN_SCREEN_SELECT_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestStationManageScreenSelect() {
        OutputView.printStationManageScreen();
        try {
            return validateStationManageScreenSelect(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestStationManageScreenSelect();
        }
    }

    static String validateStationManageScreenSelect(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(STATION_MANAGE_SCREEN_SELECT_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestLineManageScreenSelect() {
        OutputView.printLineManageScreen();
        try {
            return validateLineManageScreenSelect(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestStationManageScreenSelect();
        }
    }

    static String validateLineManageScreenSelect(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(LINE_MANAGE_SCREEN_SELECT_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestSectionManageScreenSelect() {
        OutputView.printSectionManageScreen();
        try {
            return validateSectionManageScreenSelect(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestSectionManageScreenSelect();
        }
    }

    static String validateSectionManageScreenSelect(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(SECTION_MANAGE_SCREEN_SELECT_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestRegisterStation() {
        OutputView.printRequestRegisterStation();
        try {
            return validateRegisterStation(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterStation();
        }
    }

    static String validateRegisterStation(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(STATION_REGEX, input) || isExistStation(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static boolean isExistStation(String stationName) {
        return StationRepository.isExist(stationName);
    }

    public static String requestDeleteStation() {
        OutputView.printRequestDeleteStation();
        try {
            return validateIsExistStation(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestDeleteStation();
        }
    }

    static String validateIsExistStation(String input) {
        input = Utils.deleteAllSpace(input);
        if (!StationRepository.isExist(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestRegisterLine() {
        OutputView.printRequestLineRegister();
        try {
            return validateRegisterLine(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterLine();
        }
    }

    static String validateRegisterLine(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(LINE_REGEX, input) || isExistLine(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static boolean isExistLine(String lineName) {
        return LineRepository.isExist(lineName);
    }

    public static String requestDeleteLine() {
        OutputView.printRequestLineDelete();
        try {
            return validateIsExistLine(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestDeleteLine();
        }
    }

    static String validateIsExistLine(String input) {
        input = Utils.deleteAllSpace(input);
        if (!LineRepository.isExist(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestRegisterLineFirstStation() {
        OutputView.printRequestRegisterLineFirstStation();
        try {
            return validateRegisterLineFirstStation(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterLineFirstStation();
        }
    }

    static String validateRegisterLineFirstStation(String input) {
        input = Utils.deleteAllSpace(input);
        if (!StationRepository.isExist(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestRegisterLineLastStation(String firstStation) {
        OutputView.printRequestRegisterLineLastStation();
        try {
            return validateRegisterLineLastStation(scanner.nextLine(), firstStation);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterLineLastStation(firstStation);
        }
    }

    static String validateRegisterLineLastStation(String input, String firstStation) {
        input = Utils.deleteAllSpace(input);
        firstStation = Utils.deleteAllSpace(firstStation);
        if (input.equals(firstStation) || !StationRepository.isExist(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestRegisterSectionLine() {
        OutputView.printRequestRegisterSectionLine();
        try {
            return validateIsExistLine(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterSectionLine();
        }
    }

    public static String requestRegisterSectionStation() {
        OutputView.printRequestRegisterSectionStation();
        try {
            return validateIsExistStation(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterSectionStation();
        }
    }

    public static int requestRegisterSectionOrder(String lineName) {
        OutputView.printRequestRegisterSectionOrder();
        try {
            return validateRegisterSectionOrder(scanner.nextLine(), lineName);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterSectionOrder(lineName);
        }
    }

    static int validateRegisterSectionOrder(String input, String lineName) {
        input = Utils.deleteAllSpace(input);
        lineName = Utils.deleteAllSpace(lineName);
        if (!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        int order = Integer.parseInt(input) - ONE;

        if (isInvalidSectionStationOrderRange(lineName, order)) {
            throw new IllegalArgumentException();
        }
        return order;
    }

    private static boolean isInvalidSectionStationOrderRange(String lineName, int order) {
        return order > LineRepository.getLines()
            .findLineByName(lineName)
            .getStations()
            .get()
            .size();
    }

    public static String requestDeleteSectionLine() {
        OutputView.printRequestDeleteSectionLine();
        return scanner.nextLine();
    }

    public static String requestDeleteSectionStation() {
        OutputView.printRequestDeleteSectionStation();
        return scanner.nextLine();
    }
}
