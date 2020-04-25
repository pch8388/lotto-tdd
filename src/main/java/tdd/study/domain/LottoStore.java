package tdd.study.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static List<LottoTicket> buy(int price) {
        List<LottoTicket> tickets = new ArrayList<>();
        final int buyCount = price / 1000;
        for (int i = 0; i < buyCount; i++) {
            tickets.add(LottoCreator.create());
        }
        return tickets;
    }
}
