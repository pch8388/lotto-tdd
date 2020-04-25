package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {

    @DisplayName("금액에 맞게 로또를 구매한다")
    @Test
    public void buyLotto() {
        final int price = 10000;
        List<LottoTicket> tickets = LottoStore.buy(price);

        assertThat(tickets.size()).isEqualTo(10);
    }

    @DisplayName("정상적인 금액이 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {10500, -1000, 0, 12003})
    public void validatePrice(int price) {
        assertThatThrownBy(() -> LottoStore.buy(price))
            .isInstanceOf(IllegalArgumentException.class);
    }
}