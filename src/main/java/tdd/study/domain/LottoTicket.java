package tdd.study.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket of(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        return new LottoTicket(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 사이즈는 6개!!");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("같은 숫자가 중복되면 안됩니다.");
        }
    }

    public boolean isWinner(LottoTicket winner) {
        return winner.getLottoNumbers().containsAll(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
