package racingcar.utils;

import java.util.List;

import static racingcar.constant.ErrorMessage.TOTAL_ROUND_INPUT_ERROR;

public class InputParse {
    private static final String CAR_NAME_DELIMITER = ",";

    public static List<String> splitInputCarNames(String input) {
        return List.of(input.split(CAR_NAME_DELIMITER));
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) { // input을 숫자로 바꿀 수 없으면 오류를 발생시킴
            throw new IllegalArgumentException(TOTAL_ROUND_INPUT_ERROR.getErrorMessage());
        }
    }
}