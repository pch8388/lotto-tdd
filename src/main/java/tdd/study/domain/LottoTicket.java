package tdd.study.domain;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    private LottoTicket(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public static LottoTicket of(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public Rank getRank(LottoNumbers winner, LottoNumber bonusNumber) {
        return Rank.valueOf(lottoNumbers.match(winner), lottoNumbers.isContains(bonusNumber));
    }

    @Override
    public String toString() {
        return lottoNumbers.print();
    }
}
