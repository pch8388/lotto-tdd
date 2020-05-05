package tdd.study.domain;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    private LottoTicket(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket of(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public Rank getRank(LottoNumbers winner) {
        return Rank.valueOf(lottoNumbers.match(winner));
    }

    @Override
    public String toString() {
        return lottoNumbers.print();
    }
}
