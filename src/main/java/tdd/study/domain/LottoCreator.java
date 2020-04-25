package tdd.study.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoCreator {

    private static final List<Integer> numbers;

    static {
        numbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(toList());
    }

    public static LottoTicket create() {
        Collections.shuffle(numbers);
        return LottoTicket.of(numbers.subList(0, 6));
    }
}
