package tdd.study.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static tdd.study.domain.LottoStore.UNIT_PRICE;

public class Winner {

    private static final long DEFAULT_VALUE = 0L;
    private final Map<Rank, Long> winners;
    private final int price;

    private Winner(List<Rank> ranks) {
        this.winners = ranks.stream()
            .collect(groupingBy(identity(), counting()));
        this.price = ranks.size() * UNIT_PRICE;
    }

    public static Winner of(List<LottoTicket> tickets, LottoNumbers winLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            ranks.add(ticket.getRank(winLotto));
        }
        return new Winner(ranks);
    }

    public Long countOfWinner(Rank rank) {
        return winners.getOrDefault(rank, DEFAULT_VALUE);
    }

    public double profitRate() {
        return winners.entrySet()
            .stream()
            .mapToLong(Winner::applyAsLong)
            .sum() / (double) price;

    }

    private static long applyAsLong(Map.Entry<Rank, Long> rank) {
        return rank.getKey().getMoney(rank.getValue());
    }
}
