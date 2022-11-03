package subway.view;

import java.util.Scanner;
import java.util.regex.Pattern;
import subway.utils.Utils;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String MAIN_SCREEN_SELECT_REGEX = "^[1234qQ]$";

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
        return scanner.nextLine();
    }

    public static String requestLineManageScreenSelect() {
        OutputView.printLineManageScreen();
        return scanner.nextLine();
    }

    public static String requestSectionManageScreenSelect() {
        OutputView.printSectionManageScreen();
        return scanner.nextLine();
    }

    public static String requestRegisterStation() {
        OutputView.printRequestRegisterStation();
        return scanner.nextLine();
    }

    public static String requestDeleteStation() {
        OutputView.printRequestDeleteStation();
        return scanner.nextLine();
    }

    public static String requestRegisterLine() {
        OutputView.printRequestLineRegister();
        return scanner.nextLine();
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
