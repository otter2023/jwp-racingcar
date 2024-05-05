package racingcar.service;

import org.springframework.stereotype.Service;
import racingcar.domain.Cars;
import racingcar.domain.Car;
import racingcar.dto.GameInitializationRequest;
import racingcar.dto.GameResultResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RacingCarService {

    // 경주를 시작하고 결과를 반환하는 메소드
    public GameResultResponse startRace(GameInitializationRequest gameInitializationRequest) {
        validateRequest(gameInitializationRequest);

        // 자동차 객체 생성
        List<Car> cars = gameInitializationRequest.getCarNames().stream()
                .map(Car::nameFrom) // Car 클래스의 nameFrom 정적 팩토리 메소드 사용
                .collect(Collectors.toList());
        Cars carsGroup = new Cars(cars); // Cars 객체를 생성하여 모든 Car 객체를 관리

        // 경주 실행
        for (int i = 0; i < gameInitializationRequest.getTotalRound(); i++) {
            carsGroup.moveAll();
        }

        // 결과 생성 및 반환
        List<String> winners = carsGroup.getWinnerCars();
        List<String> carStatuses = carsGroup.getMessages(); // 각 차의 상태 메시지를 추가
        return new GameResultResponse(winners, carStatuses);
    }

    // 입력 데이터 검증
    private void validateRequest(GameInitializationRequest request) {
        if (request.getCarNames() == null || request.getCarNames().isEmpty() || request.getTotalRound() <= 0) {
            throw new IllegalArgumentException("Invalid input data for the race.");
        }
    }
}
