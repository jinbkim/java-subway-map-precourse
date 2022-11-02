package subway.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class StationManagementFactory {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String BACK = "B";

    private static final Map<String, Supplier<Controller>> controllerRecipe = new HashMap<>();

    static {
        controllerRecipe.put(ONE, StationRegisterController::new);
        controllerRecipe.put(TWO, StationDeleteController::new);
        controllerRecipe.put(THREE, StationLookUpController::new);
        controllerRecipe.put(BACK, MainScreenController::new);
    }

    public static Controller of(String select) {
        return controllerRecipe.get(select)
            .get();
    }
}
