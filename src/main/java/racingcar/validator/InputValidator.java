package racingcar.validator;

import static racingcar.constant.ErrorMessage.CAR_NAME_INPUT_COUNT_ERROR;

public class InputValidator {

    private static final int INPUT_MIN_SIZE = 1;

    public static void validateInputCarName(String input) {
        if (input.length() < INPUT_MIN_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_COUNT_ERROR.getErrorMessage());
        }
    }
}
