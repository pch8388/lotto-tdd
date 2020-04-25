package tdd.study.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int UNIT_PRICE = 1000;

    public static List<LottoTicket> buy(int price) {
        List<LottoTicket> tickets = new ArrayList<>();
        final int buyCount = price / UNIT_PRICE;

        for (int i = 0; i < buyCount; i++) {
            tickets.add(LottoCreator.create());
        }
        return tickets;
    }
}
