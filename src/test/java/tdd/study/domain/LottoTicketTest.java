package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {


    @DisplayName("티켓이 몇위인지 확인")
    @Test
    public void winnerCheck() {
        final LottoTicket ticket = LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        final LottoTicket ticket1 = LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 3, 4, 5, 6, 7)));
        final LottoNumbers winner = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoTicket secondTicket = LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 11)));

        final LottoNumber bonusNumber = LottoNumber.of(11);

        assertThat(ticket.getRank(winner, bonusNumber)).isEqualByComparingTo(Rank.FIRST);
        assertThat(ticket1.getRank(winner, bonusNumber)).isEqualByComparingTo(Rank.THIRD);
        assertThat(secondTicket.getRank(winner, bonusNumber)).isEqualByComparingTo(Rank.SECOND);
    }
}