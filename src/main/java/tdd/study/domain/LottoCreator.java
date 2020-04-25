package tdd.study.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoCreator {

    private static List<Integer> numbers;

    public LottoCreator() {
        numbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(toList());
    }

    public LottoTicket autoCreate() {
        Collections.shuffle(numbers);
        return LottoTicket.of(numbers.subList(0, 6));
    }

    public LottoTicket manualCreate(List<Integer> numbers) {
        return LottoTicket.of(numbers);
    }
}
