package racingcar.dto;

import java.util.List;

public class GameResultResponse {

    private List<String> winnerNames; // 경주의 승자 목록
    private List<String> carStatuses; // 모든 차량의 최종 상태 목록

    public GameResultResponse(List<String> winnerNames, List<String> carStatuses) {
        this.winnerNames = winnerNames;
        this.carStatuses = carStatuses;
    }

    // 승자 목록을 반환하는 getter
    public List<String> getWinnerNames() {
        return winnerNames;
    }

    // 차량 상태 목록을 반환하는 getter
    public List<String> getCarStatuses() {
        return carStatuses;
    }

    // 승자 목록을 설정하는 setter
    public void setWinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    // 차량 상태 목록을 설정하는 setter
    public void setCarStatuses(List<String> carStatuses) {
        this.carStatuses = carStatuses;
    }
}
