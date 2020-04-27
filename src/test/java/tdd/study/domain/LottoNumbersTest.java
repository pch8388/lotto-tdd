package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    @DisplayName("6자리가 아닌 수가 입력되면 예외를 발생시킨다")
    @Test
    public void validateSize() {
        assertThatThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class).hasMessage("로또 사이즈는 6개!!");
    }

    @DisplayName("같은 숫자가 중복되서는 안된다")
    @Test
    public void validateDuplicate() {
        assertThatThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class).hasMessage("같은 숫자가 중복되면 안됩니다.");
    }

    @DisplayName("당첨번호와 맞는 개수 확인")
    @Test
    public void winNumbers() {
        final LottoNumbers numbers1 = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers numbers2 = LottoNumbers.of(Arrays.asList(1, 2, 3, 7, 8, 9));
        final LottoNumbers numbers3 = LottoNumbers.of(Arrays.asList(10, 12, 13, 15, 18, 19));

        final LottoNumbers winNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(numbers1.match(winNumbers)).isEqualTo(6);
        assertThat(numbers2.match(winNumbers)).isEqualTo(3);
        assertThat(numbers3.match(winNumbers)).isEqualTo(0);
    }
}