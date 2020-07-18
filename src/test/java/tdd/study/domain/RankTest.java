package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("당첨 순위 매칭 확인")
    public void valueOf() {
        boolean bonusNumber = true;
        final Rank fifth = Rank.valueOf(3, bonusNumber);
        final Rank second = Rank.valueOf(5, bonusNumber);

        assertThat(fifth).isEqualTo(Rank.FIFTH);
        assertThat(second).isEqualTo(Rank.SECOND);
    }
}