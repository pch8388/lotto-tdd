package tdd.study.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    private final int number;

    static {
        IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .forEach(i -> cache.put(i, new LottoNumber(i)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(cache.get(number)).orElseGet(() -> {
            throw new IllegalArgumentException();
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
