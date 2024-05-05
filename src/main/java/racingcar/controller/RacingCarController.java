package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.utils.InputParse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;
import java.util.List;

public class RacingCarController {
    private static final int ROUND_STEP = 1;

    public void run() throws IOException {
        Cars cars = inputRacingCarName();
        Round round = inputRound();

        startGame(cars, round);
        findWinner(cars);
    }

    private void findWinner(Cars cars) {
        List<String> winnerNames = cars.getWinnerCars();
        OutputView.printWinners(winnerNames);
    }

    private void startGame(Cars cars, Round round) {
        OutputView.printResultHeader();
        while (!round.isGameOver()) {
            cars.moveAll();
            List<String> messages = cars.getMessages();
            OutputView.printResult(messages);
            round.step(ROUND_STEP);
        }
    }

    private Round inputRound() throws IOException {
        String input = InputView.inputRound();
        int totalRound = InputParse.parseInt(input);
        return Round.totalRoundFrom(totalRound);
    }

    private Cars inputRacingCarName() throws IOException {
        String input = InputView.inputCarNames();
        List<String> carNames = InputParse.splitInputCarNames(input);
        return Cars.carNamesFrom(carNames);
    }
}
