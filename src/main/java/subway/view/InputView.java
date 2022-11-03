package subway.view;

import java.util.Scanner;
import java.util.regex.Pattern;
import subway.model.line.LineRepository;
import subway.model.station.StationRepository;
import subway.utils.Utils;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String MAIN_SCREEN_SELECT_REGEX = "^[1234qQ]$";
    private static final String STATION_MANAGE_SCREEN_SELECT_REGEX = "^[123bB]$";
    private static final String LINE_MANAGE_SCREEN_SELECT_REGEX = "^[123bB]$";
    private static final String SECTION_MANAGE_SCREEN_SELECT_REGEX = "^[12bB]$";

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
            return validateDeleteStation(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongInput();
            return requestDeleteStation();
        }
    }

    static String validateDeleteStation(String input) {
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
        return scanner.nextLine();
    }

    public static String requestLine() {
        OutputView.printRequestLine();
        return scanner.nextLine();
    }

    public static String requestDeleteSectionLine() {
        OutputView.printRequestDeleteSectionLine();
        return scanner.nextLine();
    }

    public static String requestRegisterLineFirstStation() {
        OutputView.printRequestRegisterLineFirstStation();
        return scanner.nextLine();
    }

    public static String requestRegisterLineLastStation() {
        OutputView.printRequestRegisterLineLastStation();
        return scanner.nextLine();
    }

    public static String requestStation() {
        OutputView.printRequestStation();
        return scanner.nextLine();
    }

    public static int requestOrder() {
        OutputView.printRequestOrder();
        return Integer.parseInt(scanner.nextLine());
    }

    public static String requestDeleteSectionStation() {
        OutputView.printRequestDeleteSectionStation();
        return scanner.nextLine();
    }


}
