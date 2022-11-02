package subway.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MainScreenNavigationFactory {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String QUIT = "Q";

    private static final Map<String, Supplier<Controller>> controllerRecipe = new HashMap<>();

    static {
        controllerRecipe.put(ONE, StationManageController::new);
        controllerRecipe.put(TWO, LineManageController::new);
        controllerRecipe.put(THREE, SectionManageController::new);
        controllerRecipe.put(FOUR, MapPrintController::new);
        controllerRecipe.put(QUIT, EndController::new);
    }

    public static Controller of(String select) {
        return controllerRecipe.get(select)
            .get();
    }
}
