package tdd.study.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int UNIT_PRICE = 1000;
    private static final int START_INDEX = 0;
    private static final int VALID_NUMBER = 0;
    private static final String validMessage = "정상적인 금액이 아닙니다.";

    public static List<LottoTicket> buy(int price) {
        validatePrice(price);
        final int buyCount = price / UNIT_PRICE;

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = START_INDEX; i < buyCount; i++) {
            tickets.add(LottoCreator.create());
        }
        return tickets;
    }

    private static void validatePrice(int price) {
        if (price <= VALID_NUMBER) {
            throw new IllegalArgumentException(validMessage);
        }
        if (price % UNIT_PRICE != VALID_NUMBER) {
            throw new IllegalArgumentException(validMessage);
        }
    }
}
