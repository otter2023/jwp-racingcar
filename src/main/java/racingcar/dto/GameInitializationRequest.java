package racingcar.dto;

public class GameInitializationRequest {

    private String names; // 참가할 자동차 이름 목록
    private int count;        // 실행할 라운드 수

    // 기본 생성자
    public GameInitializationRequest() {
    }

    // 모든 필드를 초기화하는 생성자
    public GameInitializationRequest(String names, int count) {
        this.names = names;
        this.count = count;
    }

    // 차량 이름 목록을 반환하는 getter
    public String getNames() {
        return names;
    }

    // 라운드 수를 반환하는 getter
    public int getCount() {
        return count;
    }


}
