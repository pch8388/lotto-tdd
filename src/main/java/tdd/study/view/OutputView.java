package tdd.study.view;

import tdd.study.domain.LottoTicket;
import tdd.study.domain.Rank;
import tdd.study.domain.Winner;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

public class OutputView {

    private static final String BUYING_COUNT_MESSAGE = "%d개를 구매하였습니다.";
    private static final String STATISTICS_INFO_MESSAGE = "당첨통계";
    private static final String STATISTICS_INFO_LINE = "------------";
    private static final String WINNER_FORMAT = "%s (%d원) - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f입니다.";

    private static final PrintStream OUT = System.out;

    public static void printlnMessage(final String message) {
        print(message);
    }

    public static void printBuyLotto(final List<LottoTicket> lottoTickets) {
        print(String.format(BUYING_COUNT_MESSAGE, lottoTickets.size()));
        lottoTickets.forEach(OutputView::print);
    }

    public static void printStatistics(final Winner winner) {
        print(STATISTICS_INFO_MESSAGE);
        print(STATISTICS_INFO_LINE);

        Stream.of(Rank.values())
            .filter(rank -> rank.getCountOfMatch() > 0)
            .forEach(rank ->
                print(String.format(
                    WINNER_FORMAT, rank.getMessage(),
                    rank.getWinningMoney(), winner.countOfWinner(rank))));

        print(String.format(PROFIT_RATE_FORMAT, winner.profitRate()));
    }

    private static void print(final Object message) {
        OUT.println(message);
    }
}
