package racingcar.service;

import org.springframework.stereotype.Service;
import racingcar.controller.RacingCarController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.dto.GameInitializationRequest;
import racingcar.dto.GameResultResponse;
import racingcar.utils.InputParse;

import java.util.List;

@Service
public class RacingCarService {

    private final RacingCarController racingCarController;

    public RacingCarService(RacingCarController racingCarController) {
        this.racingCarController = racingCarController;
    }


    // 경주를 시작하고 결과를 반환하는 메소드
    public GameResultResponse startRace(GameInitializationRequest gameInitializationRequest) {
        Cars cars = Cars.carNamesFrom(InputParse.splitInputCarNames(gameInitializationRequest.getNames()));
        Round round = Round.totalRoundFrom(gameInitializationRequest.getCount());

        racingCarController.startGame(cars, round);

        List<Car> result = cars.getCars();
        List<String> winners = racingCarController.findWinner(cars);

        return new GameResultResponse(String.join(",", winners), result);
    }
}
