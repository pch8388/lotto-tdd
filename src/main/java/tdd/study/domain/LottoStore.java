package tdd.study.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int UNIT_PRICE = 1000;
    private static final String validMessage = "정상적인 금액이 아닙니다.";

    public static List<LottoTicket> buy(int price) {
        validatePrice(price);
        final int buyCount = price / UNIT_PRICE;

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            tickets.add(LottoCreator.create());
        }
        return tickets;
    }

    private static void validatePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(validMessage);
        }
        if (price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(validMessage);
        }
    }
}
