package tdd.study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCreatorTest {

    @DisplayName("자동으로 로또번호 생성")
    @Test
    public void create() {
        LottoTicket lottoTicket = LottoCreator.create();

        assert lottoTicket != null;
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

}