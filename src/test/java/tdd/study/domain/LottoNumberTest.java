package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("번호 생성 확인")
    @Test
    public void create() {
        LottoNumber number = LottoNumber.of(40);
        assertThat(number).isEqualTo(LottoNumber.of(40));
    }

    @DisplayName("번호가 1 ~ 45 범위 내의 숫자가 아니면 예외를 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 60, Integer.MAX_VALUE, Integer.MIN_VALUE})
    public void validRange(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}