package subway.view;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.repository.SubwayMapRepository;

class InputViewTest {

    @BeforeEach
    void setUp() {
        StationRepository.clear();
        LineRepository.clear();
    }

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

        StationRepository.add(" 충 정 로 역 ");
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation(" 술 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation("술"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation(" 충  정  로  역 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation("충정로역"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation(""));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterStation(" "));
    }

    @Test
    void 역관리_역삭제_예외처리() {
        StationRepository.add(" 충 정 로 역 ");

        Assertions.assertThatCode(() -> InputView.validateIsExistStation("  충 정 로 역  "))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateIsExistStation("충정로역"))
                .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateIsExistStation("아현역"));
    }

    @Test
    void 노선관리_노선등록_노선이름_예외처리() {
        Assertions.assertThatCode(() -> InputView.validateRegisterLine("9호선"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRegisterLine("  9 호 선  "))
                .doesNotThrowAnyException();

        SubwayMapRepository.addStations(" 9 호 선 ", Arrays.asList("아무나역"));
        LineRepository.add(" 9 호 선 ");
        StationRepository.add(" 아 무 나 역 ");
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine(" 술 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine("술"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine(" 9 호 선 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine("9호선"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine(""));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLine(" "));
    }

    @Test
    void 노선관리_노선삭제_예외처리() {
        Assertions.assertThatThrownBy(() -> InputView.validateIsExistLine(" 9 호 선 "));
        Assertions.assertThatThrownBy(() -> InputView.validateIsExistLine("9호선"));

        SubwayMapRepository.addStations(" 9 호 선 ", Arrays.asList("아무나역"));
        LineRepository.add(" 9 호 선 ");
        StationRepository.add(" 아 무 나 역 ");
        Assertions.assertThatCode(() -> InputView.validateIsExistLine("9호선"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateIsExistLine("  9 호 선  "))
                .doesNotThrowAnyException();
    }

    @Test
    void 노선관리_노선등록_상행종점역_예외처리() {
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLineFirstStation(" 충 정 로 역 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLineFirstStation("충정로역"));

        StationRepository.add(" 충 정 로 역 ");
        Assertions.assertThatCode(() -> InputView.validateRegisterLineFirstStation("충정로역"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRegisterLineFirstStation("  충 정 로 역  "))
                .doesNotThrowAnyException();
    }

    @Test
    void 노선관리_노선등록_하행종점역_예외처리() {
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLineLastStation(" 충 정 로 역 ", " 아 현 역 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLineLastStation("충정로역", " 아 현 역 "));

        StationRepository.add(" 충 정 로 역 ");
        Assertions.assertThatCode(() -> InputView.validateRegisterLineLastStation("충정로역", " 아 현 역 "))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> InputView.validateRegisterLineLastStation("  충 정 로 역  ", " 아 현 역 "))
                .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLineLastStation(" 아 현 역 ", " 아 현 역 "));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterLineLastStation("아현역", " 아 현 역 "));
    }

    @Test
    void 구간관리_구간등록_예외처리() {
        LineRepository.add(" 9 호 선 ");
        StationRepository.add("첫번째역");
        StationRepository.add("두번째역");
        SubwayMapRepository.addStations(" 9 호 선 ", Arrays.asList("첫번째역", "두번째역"));
        Assertions.assertThatCode(() -> InputView.validateRegisterSectionOrder(" 3 ", "9호선"))
                .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputView.validateRegisterSectionOrder("넷", "9호선"));
        Assertions.assertThatThrownBy(() -> InputView.validateRegisterSectionOrder("5", "9호선"));
    }

    @Test
    void 구간관리_구간삭제_예외처리() {
        LineRepository.add(" 9 호 선 ");
        StationRepository.add("첫번째역");
        StationRepository.add("두번째역");
        StationRepository.add("세번째역");
        SubwayMapRepository.addStations(" 9 호 선 ", Arrays.asList("첫번째역", "두번째역", "세번째역"));

        Assertions.assertThatCode(() -> InputView.validateDeleteSectionLine(" 9 호 선 "))
                .doesNotThrowAnyException();

        SubwayMapRepository.addStations(" 8 호 선 ", Arrays.asList("첫번째역", "두번째역"));
        Assertions.assertThatThrownBy(() -> InputView.validateDeleteSectionLine("7호선"));
        Assertions.assertThatThrownBy(() -> InputView.validateDeleteSectionLine("8호선"));
    }
}