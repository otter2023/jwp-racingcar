package racingcar.domain;

import static racingcar.constant.ErrorMessage.TOTAL_ROUND_INPUT_ERROR;

public class Round {
    private static final int MIN_ROUND = 1;
    private static final int DEFAULT_ROUND = 0;
    private final int totalRound;
    private int nowRound;

    public Round(int totalRound, int nowRound) {
        this.totalRound = totalRound;
        this.nowRound = nowRound;
    }

    // 그러니까 이제 생성자 대신 이렇게 쓰는게 좋음!
    public static Round totalRoundFrom(int totalRound) {
        validate(totalRound);
        return new Round(totalRound, DEFAULT_ROUND);
    }

    private static void validate(int totalRound) {
        if (totalRound < MIN_ROUND) {
            throw new IllegalArgumentException(TOTAL_ROUND_INPUT_ERROR.getErrorMessage());
        }
    }

    public boolean isGameOver() {
        return nowRound >= totalRound;
    }

    public void step(int round) {
        nowRound += round;
    }
}
