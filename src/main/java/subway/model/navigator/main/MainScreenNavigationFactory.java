package subway.model.navigator.main;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import subway.model.navigator.Navigator;

public class MainScreenNavigationFactory {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String QUIT = "Q";

    private static final Map<String, Supplier<Navigator>> navigatorRecipe = new HashMap<>();

    static {
        navigatorRecipe.put(ONE, StationManageNavigator::new);
        navigatorRecipe.put(TWO, LineManageNavigator::new);
        navigatorRecipe.put(THREE, SectionManageNavigator::new);
        navigatorRecipe.put(FOUR, MapPrintNavigator::new);
        navigatorRecipe.put(QUIT, EndNavigator::new);
    }

    public static Navigator of(String select) {
        return navigatorRecipe.get(select)
            .get();
    }
}
