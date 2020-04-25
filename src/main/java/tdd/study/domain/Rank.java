package tdd.study.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, "0개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final int countOfMatch;
    private final int winningMoney;
    private final String message;

    private Rank(int countOfMatch, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(Rank.values())
            .filter(r -> r.countOfMatch == countOfMatch)
            .findAny()
            .orElse(Rank.MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        return message;
    }
}
