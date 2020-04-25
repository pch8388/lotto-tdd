package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoTicketTest {


    @DisplayName("당첨된 티켓인지 확인")
    @Test
    public void winnerCheck() {
        final LottoTicket ticket = LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        final LottoTicket ticket1 = LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 3, 4, 5, 6, 7)));
        final LottoTicket winner = LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

//        assertThat(ticket.isWinner(winner)).isTrue();
//        assertThat(ticket1.isWinner(winner)).isFalse();
    }
}