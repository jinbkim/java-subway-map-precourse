package subway.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 메인화면_예외처리() {
        Assertions.assertThatCode(() -> InputView.validateMainScreenSelect("  1  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateMainScreenSelect("  2  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateMainScreenSelect("  3  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateMainScreenSelect("  4  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateMainScreenSelect("  q  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateMainScreenSelect("  Q  "))
            .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateMainScreenSelect("0"));
        Assertions.assertThatThrownBy(() -> InputView.validateMainScreenSelect("11"));
        Assertions.assertThatThrownBy(() -> InputView.validateMainScreenSelect("5"));
        Assertions.assertThatThrownBy(() -> InputView.validateMainScreenSelect("1a"));
        Assertions.assertThatThrownBy(() -> InputView.validateMainScreenSelect("a"));
        Assertions.assertThatThrownBy(() -> InputView.validateMainScreenSelect(""));
        Assertions.assertThatThrownBy(() -> InputView.validateMainScreenSelect(" "));
    }

    @Test
    void 역관리화면_예외처리() {
        Assertions.assertThatCode(() -> InputView.validateStationManageScreenSelect("  1  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateStationManageScreenSelect("  2  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateStationManageScreenSelect("  3  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateStationManageScreenSelect("  b  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateStationManageScreenSelect("  B  "))
            .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateStationManageScreenSelect("0"));
        Assertions.assertThatThrownBy(() -> InputView.validateStationManageScreenSelect("11"));
        Assertions.assertThatThrownBy(() -> InputView.validateStationManageScreenSelect("5"));
        Assertions.assertThatThrownBy(() -> InputView.validateStationManageScreenSelect("1a"));
        Assertions.assertThatThrownBy(() -> InputView.validateStationManageScreenSelect("a"));
        Assertions.assertThatThrownBy(() -> InputView.validateStationManageScreenSelect(""));
        Assertions.assertThatThrownBy(() -> InputView.validateStationManageScreenSelect(" "));
    }
}