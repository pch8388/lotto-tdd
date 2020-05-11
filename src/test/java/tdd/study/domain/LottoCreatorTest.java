package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCreatorTest {

    @DisplayName("자동으로 로또번호 생성")
    @Test
    public void create() {
        LottoTicket lottoTicket = new LottoCreator().autoCreate();
        final Rank rank =
            lottoTicket.getRank(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(rank).isInstanceOf(Rank.class);
    }

}