package racingcar.constant;

import java.util.List;
import java.util.StringJoiner;

public enum ViewMessage {
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ROUND_MESSAGE("시도할 회수는 몇회인가요?"),
    RUN_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : " ),;

    private final String message;
    private static final String WINNER_DELIMITER = ", ";

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String printWinner(List<String> winnerNames) {
        StringJoiner winners = new StringJoiner(WINNER_DELIMITER);

        winnerNames.forEach(winners::add);

        /*
        for(String winnerName: winnerNames) {
            winners.add(winnerName);
        }
         */

        return message + winners;
    }
}
