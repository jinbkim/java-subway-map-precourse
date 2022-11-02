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

    //    public static String requestRegisterStation() {
    //        OutputView.printRequestRegisterStation();
    //        return scanner.nextLine();
    //    }
}
