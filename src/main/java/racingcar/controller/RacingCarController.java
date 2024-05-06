package racingcar.controller;

import org.springframework.stereotype.Component;
import racingcar.domain.Cars;
import racingcar.domain.Round;

import java.util.ArrayList;
import java.util.List;

@Component
public class RacingCarController {
    private static final int ROUND_STEP = 1;

    public List<String> findWinner(Cars cars) {
        return cars.getWinnerCars();
    }

    public List<String> startGame(Cars cars, Round round) {
        List<String> result = new ArrayList<>();
        while (!round.isGameOver()) {
            cars.moveAll();
            List<String> messages = cars.getMessages();
//            OutputView.printResult(messages);
            result.addAll(messages);
            round.step(ROUND_STEP);
        }

        return result;
    }
}
