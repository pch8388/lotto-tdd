package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @DisplayName("당첨된 로또의 랭크확인")
    @Test
    public void rank() {
        final List<LottoTicket> tickets = Arrays.asList(
            LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(3, 4, 5, 6, 9, 10))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 6, 8, 9))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(4, 5, 6, 8, 9, 12))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 3, 16, 17, 39, 40))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(9, 12, 13, 34, 44, 45)))
        );
        final List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Winner winner = Winner.of(tickets, LottoNumbers.of(winNumbers));
        assertThat(winner.countOfWinner(Rank.FIRST)).isEqualTo(1);
        assertThat(winner.countOfWinner(Rank.FOURTH)).isEqualTo(2);
        assertThat(winner.countOfWinner(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("수익률 계산")
    @Test
    public void profitRate() {
        final List<LottoTicket> tickets = Arrays.asList(
            LottoTicket.of(LottoNumbers.of(Arrays.asList(3, 4, 5, 6, 9, 10))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 6, 8, 9))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(4, 5, 6, 8, 9, 12))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(1, 3, 16, 17, 39, 40))),
            LottoTicket.of(LottoNumbers.of(Arrays.asList(9, 12, 13, 34, 44, 45)))
        );
        final List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        long lotteryPrize = 105_000;
        int price = 5000;
        // 4등 2개, 5등 1개
        Winner winner = Winner.of(tickets, LottoNumbers.of(winNumbers));
        assertThat(winner.profitRate()).isEqualTo(lotteryPrize / (double) price);
    }
}