package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;

public class GameResultResponse {

    private String winners; // 경주의 승자 목록
    private List<Car> racingCars; // 모든 차량의 최종 상태 목록

    public GameResultResponse(String winners, List<Car> racingCars) {
        this.winners = winners;
        this.racingCars = racingCars;
    }

    public String getWinners() {
        return winners;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
