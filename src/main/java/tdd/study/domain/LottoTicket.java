package tdd.study.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private static final int LOTTO_SIZE = 6;
    private final Set<Integer> lottoNumbers;

    private LottoTicket(Set<Integer> numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket of(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 사이즈는 6개!!");
        }

        return new LottoTicket(lottoNumbers);
    }

    public boolean isWinner(LottoTicket winner) {
        return winner.getLottoNumbers().containsAll(lottoNumbers);
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
