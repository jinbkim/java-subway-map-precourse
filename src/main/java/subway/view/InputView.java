package subway.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestMainScreenSelect() {
        OutputView.printMainScreen();
        return scanner.nextLine();
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


}
