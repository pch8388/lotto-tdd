package tdd.study.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket of(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 사이즈는 6개!!");
        }
        return new LottoTicket(numbers);
    }
}
