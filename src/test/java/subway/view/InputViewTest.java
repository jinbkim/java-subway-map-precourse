package subway.view;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.model.line.Line;
import subway.model.line.LineRepository;
import subway.model.station.Station;
import subway.model.station.StationRepository;

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

    @Test
    void 노선관리화면_예외처리() {
        Assertions.assertThatCode(() -> InputView.validateLineManageScreenSelect("  1  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateLineManageScreenSelect("  2  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateLineManageScreenSelect("  3  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateLineManageScreenSelect("  b  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateLineManageScreenSelect("  B  "))
            .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateLineManageScreenSelect("0"));
        Assertions.assertThatThrownBy(() -> InputView.validateLineManageScreenSelect("11"));
        Assertions.assertThatThrownBy(() -> InputView.validateLineManageScreenSelect("5"));
        Assertions.assertThatThrownBy(() -> InputView.validateLineManageScreenSelect("1a"));
        Assertions.assertThatThrownBy(() -> InputView.validateLineManageScreenSelect("a"));
        Assertions.assertThatThrownBy(() -> InputView.validateLineManageScreenSelect(""));
        Assertions.assertThatThrownBy(() -> InputView.validateLineManageScreenSelect(" "));
    }

    @Test
    void 구간관리화면_예외처리() {
        Assertions.assertThatCode(() -> InputView.validateSectionManageScreenSelect("  1  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateSectionManageScreenSelect("  2  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateSectionManageScreenSelect("  b  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateSectionManageScreenSelect("  B  "))
            .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateSectionManageScreenSelect("0"));
        Assertions.assertThatThrownBy(() -> InputView.validateSectionManageScreenSelect("11"));
        Assertions.assertThatThrownBy(() -> InputView.validateSectionManageScreenSelect("3"));
        Assertions.assertThatThrownBy(() -> InputView.validateSectionManageScreenSelect("1a"));
        Assertions.assertThatThrownBy(() -> InputView.validateSectionManageScreenSelect("a"));
        Assertions.assertThatThrownBy(() -> InputView.validateSectionManageScreenSelect(""));
        Assertions.assertThatThrownBy(() -> InputView.validateSectionManageScreenSelect(" "));
    }

    @Test
    void 역관리_역등록_예외처리() {
        Assertions.assertThatCode(() -> InputView.validateRegisterStation("  a b  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRegisterStation("  충 정 로 역  "))
            .doesNotThrowAnyException();

        StationRepository.add(new Station(" 충 정 로 역 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation(" 술 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation("술"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation(" 충  정  로  역 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation("충정로역"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation(""));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation(" "));
    }

    @Test
    void 역관리_역삭제_예외처리() {
        StationRepository.add(new Station(" 충 정 로 역 "));

        Assertions.assertThatCode(() -> InputView.validateDeleteStation("  충 정 로 역  "))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateDeleteStation("충정로역"))
            .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateDeleteStation("아현역"));
    }

    @Test
    void 노선관리_노선등록_노선이름_예외처리() {
        Assertions.assertThatCode(() -> InputView.validateRegisterLine("9호선"))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRegisterLine("  9 호 선  "))
            .doesNotThrowAnyException();

        LineRepository.add(new Line(" 9 호 선 ", Arrays.asList("아무나역")));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine(" 술 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine("술"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine(" 9 호 선 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine("9호선"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine(""));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine(" "));
    }

    @Test
    void 노선관리_노선삭제_예외처리() {
        Assertions.assertThatThrownBy(() -> InputView.validateDeleteLine(" 9 호 선 "));
        Assertions.assertThatThrownBy(() -> InputView.validateDeleteLine("9호선"));

        LineRepository.add(new Line(" 9 호 선 ", Arrays.asList("아무나역")));
        Assertions.assertThatCode(() -> InputView.validateDeleteLine("9호선"))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateDeleteLine("  9 호 선  "))
            .doesNotThrowAnyException();
    }

}