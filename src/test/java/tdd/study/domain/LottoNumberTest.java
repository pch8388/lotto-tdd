package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("번호 생성 확인")
    @Test
    public void create() {
        LottoNumber number = LottoNumber.of(40);
        assertThat(number).isEqualTo(LottoNumber.of(40));
    }
}