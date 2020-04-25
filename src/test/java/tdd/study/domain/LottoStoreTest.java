package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @DisplayName("금액에 맞게 로또를 구매한다")
    @Test
    public void buyLotto() {
        final int price = 10000;
        List<LottoTicket> tickets = LottoStore.buy(price);

        assertThat(tickets.size()).isEqualTo(10);
    }
}