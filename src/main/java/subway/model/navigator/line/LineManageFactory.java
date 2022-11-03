package subway.model.navigator.line;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import subway.model.navigator.Navigator;
import subway.model.navigator.main.MainScreenNavigator;

public class LineManageFactory {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String BACK = "B";

    private static final Map<String, Supplier<Navigator>> navigatorRecipe = new HashMap<>();

    static {
        navigatorRecipe.put(ONE, LineRegisterNavigator::new);
        navigatorRecipe.put(TWO, LineDeleteNavigator::new);
        navigatorRecipe.put(THREE, LineLookUpNavigator::new);
        navigatorRecipe.put(BACK, MainScreenNavigator::new);
    }

    public static Navigator of(String select) {
        return navigatorRecipe.get(select)
            .get();
    }
}
