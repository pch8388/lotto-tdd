package tdd.study.view;

import java.util.Scanner;

public class InputView {

    private static final String READ_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNER_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner READER = new Scanner(System.in);

    public static int readMoney() {
        OutputView.printlnMessage(READ_MONEY_MESSAGE);
        return Integer.parseInt(READER.nextLine());
    }

    public static String readWinner() {
        OutputView.printlnMessage(WINNER_NUMBER_MESSAGE);
        return READER.nextLine();
    }
}
