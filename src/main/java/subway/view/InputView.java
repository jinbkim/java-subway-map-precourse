package subway.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String requestMainScreenSelect() {
        OutputView.printMainScreen();
        return SCANNER.nextLine();
    }

    public static String requestStationManageScreenSelect() {
        OutputView.printStationManageScreen();
        return SCANNER.nextLine();
    }

    public static String requestRegisterStation() {
        OutputView.printRequestRegisterStation();
        return SCANNER.nextLine();
    }

    public static String requestDeleteStation() {
        OutputView.printRequestDeleteStation();
        return SCANNER.nextLine();
    }
}
