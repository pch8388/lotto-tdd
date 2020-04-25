package tdd.study.domain;

import java.util.HashSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoNumbers of(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);

        return new LottoNumbers(
            numbers.stream()
                .map(LottoNumber::of)
                .collect(toList()));
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

    public String print() {
        return lottoNumbers.toString();
    }
}
