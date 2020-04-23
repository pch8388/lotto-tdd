package tdd.study.domain;

import java.util.List;

public class LottoTicket {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket of(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 사이즈는 6개!!");
        }
        return new LottoTicket(numbers);
    }
}
