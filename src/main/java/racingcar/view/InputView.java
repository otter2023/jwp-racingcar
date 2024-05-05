package racingcar.view;

import racingcar.validator.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static racingcar.constant.ViewMessage.INPUT_CAR_NAME_MESSAGE;
import static racingcar.constant.ViewMessage.INPUT_ROUND_MESSAGE;

public class InputView {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static String inputCarNames() throws IOException {
        System.out.println(INPUT_CAR_NAME_MESSAGE.getMessage());
        String input = bufferedReader.readLine();

        // 아무것도 입력되지 않은 경우
        InputValidator.validateInputCarName(input);

        return input;
    }

    public static String inputRound() throws IOException {
        System.out.println(INPUT_ROUND_MESSAGE.getMessage());
        return bufferedReader.readLine();
    }
}
