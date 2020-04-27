package tdd.study.domain;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    private LottoTicket(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket of(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public String printLottoNumbers() {
        return lottoNumbers.print();
    }

    public Rank getRank(LottoNumbers winner) {
        return Rank.valueOf(lottoNumbers.match(winner));
    }
}
