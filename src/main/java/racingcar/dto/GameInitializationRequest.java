package racingcar.dto;

import java.util.List;

public class GameInitializationRequest {

    private List<String> carNames; // 참가할 자동차 이름 목록
    private int totalRound;        // 실행할 라운드 수

    // 기본 생성자
    public GameInitializationRequest() {
    }

    // 모든 필드를 초기화하는 생성자
    public GameInitializationRequest(List<String> carNames, int totalRound) {
        this.carNames = carNames;
        this.totalRound = totalRound;
    }

    // 차량 이름 목록을 반환하는 getter
    public List<String> getCarNames() {
        return carNames;
    }

    // 차량 이름 목록을 설정하는 setter
    public void setCarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    // 라운드 수를 반환하는 getter
    public int getTotalRound() {
        return totalRound;
    }

    // 라운드 수를 설정하는 setter
    public void setTotalRound(int totalRound) {
        this.totalRound = totalRound;
    }
}
