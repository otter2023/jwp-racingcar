package racingcar.constant;

import java.util.StringJoiner;

public enum ErrorMessage {
    CAR_NAME_INPUT_COUNT_ERROR("1대 이상의 자동차를 입력해주세요."),
    CAR_NAME_LENGTH_ERROR("자동차의 이름은 1자 이상 5자 이하야야합니다."),
    CAR_NAME_INPUT_DUPLICATE_ERROR("서로 다른 자동차 이름을 입력해주세요."),
    CAR_NAME_CONTAINS_SPACE_ERROR("자동차의 이름은 공백이 포함되지 말아야합니다."),

    TOTAL_ROUND_INPUT_ERROR("1 이상의 양의 정수를 입력해야합니다."),;

    private final String message;
    private static final String ERROR = "[ERROR]";
    private static final String MESSAGE_DELIMITER = " ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        StringJoiner stringJoiner = new StringJoiner(MESSAGE_DELIMITER);
        stringJoiner.add(ERROR);
        stringJoiner.add(this.message);

        return stringJoiner.toString();
    }
}
