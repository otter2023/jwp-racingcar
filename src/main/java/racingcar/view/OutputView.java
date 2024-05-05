package racingcar.view;

import java.util.List;

import static racingcar.constant.ViewMessage.RUN_MESSAGE;
import static racingcar.constant.ViewMessage.WINNER_MESSAGE;

public class OutputView {
    public static void printResultHeader() {
        System.out.println();
        System.out.println(RUN_MESSAGE.getMessage());
    }

    public static void printResult(List<String> messages) {
        messages.forEach(System.out::println);

        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.println(WINNER_MESSAGE.printWinner(winnerNames));
    }
}
