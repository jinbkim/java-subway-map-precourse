package subway.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LineManageFactory {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String BACK = "B";

    private static final Map<String, Supplier<Controller>> controllerRecipe = new HashMap<>();

    static {
        controllerRecipe.put(ONE, LineRegisterController::new);
        controllerRecipe.put(TWO, LineDeleteController::new);
        controllerRecipe.put(THREE, LineLookUpController::new);
        controllerRecipe.put(BACK, MainScreenController::new);
    }

    public static Controller of(String select) {
        return controllerRecipe.get(select)
            .get();
    }
}
