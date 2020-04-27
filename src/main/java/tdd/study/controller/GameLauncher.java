package tdd.study.controller;

import tdd.study.domain.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GameLauncher {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(br.readLine());
        final List<LottoTicket> lottoTickets = LottoStore.buy(price);
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.printLottoNumbers()));

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = br.readLine();

        final List<Integer> winNumbers =
            Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(toList());

        final Winner winner = Winner.of(lottoTickets, LottoNumbers.of(winNumbers));

        System.out.println("당첨 통계");
        System.out.println("------------");
        Stream.of(Rank.values())
            .filter(rank -> rank.getCountOfMatch() > 0)
            .forEach(rank ->
                System.out.println(rank.getMessage() +
                    " (" + rank.getWinningMoney() + "원)- " +
                    winner.countOfWinner(rank) + "개"));

        System.out.println("총 수익률은 " + winner.profitRate() + "입니다.");
    }
}
