package tdd.study.controller;

import tdd.study.domain.LottoNumbers;
import tdd.study.domain.LottoStore;
import tdd.study.domain.LottoTicket;
import tdd.study.domain.Winner;
import tdd.study.view.InputView;
import tdd.study.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameLauncher {
    public static void main(String[] args) {

        final List<LottoTicket> lottoTickets = LottoStore.buy(InputView.readMoney());

        OutputView.printBuyLotto(lottoTickets);

        final List<Integer> winNumbers =
            Arrays.stream(InputView.readWinner().split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(toList());

        final Winner winner = Winner.of(lottoTickets, LottoNumbers.of(winNumbers));

        OutputView.printStatistics(winner);
    }
}
