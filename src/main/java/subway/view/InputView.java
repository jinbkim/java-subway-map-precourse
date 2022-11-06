package subway.view;

import java.util.Scanner;
import java.util.regex.Pattern;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.utis.Utils;

public class InputView {

    private static final int ONE = 1;
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
            return validateStationManageScreenSelect(SCANNER.nextLine());
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

    public static String requestRegisterStation() {
        OutputView.printRequestRegisterStation();
        try {
            return validateRegisterStation(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestRegisterStation();
        }
    }

    static String validateRegisterStation(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(STATION_REGEX, input) || isExistStationName(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static boolean isExistStationName(String stationName) {
        return StationRepository.isExistStationName(stationName);
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

    static String validateIsExistStation(String input) {
        input = Utils.deleteAllSpace(input);
        if (!StationRepository.isExistStationName(input)) {
            throw new IllegalArgumentException();
        }
        return input;
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

    static String validateLineManageScreenSelect(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(LINE_MANAGE_SCREEN_SELECT_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        return input;
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

    static String validateRegisterLine(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(LINE_REGEX, input) || isExistLineName(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static boolean isExistLineName(String lineName) {
        return LineRepository.isExistLineName(lineName);
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

    static String validateRegisterLineFirstStation(String input) {
        input = Utils.deleteAllSpace(input);
        if (!StationRepository.isExistStationName(input)) {
            throw new IllegalArgumentException();
        }
        return input;
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

    static String validateRegisterLineLastStation(String input, String firstStation) {
        input = Utils.deleteAllSpace(input);
        firstStation = Utils.deleteAllSpace(firstStation);
        if (input.equals(firstStation) || !StationRepository.isExistStationName(input)) {
            throw new IllegalArgumentException();
        }
        return input;
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

    static String validateIsExistLine(String input) {
        input = Utils.deleteAllSpace(input);
        if (!LineRepository.isExistLineName(input)) {
            throw new IllegalArgumentException();
        }
        return input;
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

    static String validateSectionManageScreenSelect(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(SECTION_MANAGE_SCREEN_SELECT_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static String requestRegisterSectionLine() {
        OutputView.printRequestRegisterSectionLine();
        return SCANNER.nextLine();
    }

    public static String requestRegisterSectionStation() {
        OutputView.printRequestRegisterSectionStation();
        return SCANNER.nextLine();
    }

    public static int requestRegisterSectionOrder() {
        OutputView.printRequestRegisterSectionOrder();
        return Integer.parseInt(SCANNER.nextLine()) - ONE;
    }

    public static String requestDeleteSectionLine() {
        OutputView.printRequestDeleteSectionLine();
        return SCANNER.nextLine();
    }

    public static String requestDeleteSectionStation() {
        OutputView.printRequestDeleteSectionStation();
        return SCANNER.nextLine();
    }
}
