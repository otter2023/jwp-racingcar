package racingcar.domain;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.constant.ErrorMessage.CAR_NAME_INPUT_DUPLICATE_ERROR;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    /*
        new Cars(carNames); // new를 써서 만드는 것보다
        Cars.carNamesFrom(carNames) // 이게 역할을 명시하기에 더 좋다.
        Cars.carsFrom(cars); // 참고로 인자가 여러개면 Of라고 쓴다.
    */

    // 정적 팩토리 메소드. Cars의 생성자의 인자를 List<Car>로 할 수 있다.
    public static Cars carNamesFrom(List<String> carNames) {
        validate(carNames);

        List<Car> cars = carNames.stream()
                // Car 생성
                .map(Car::nameFrom)
                .collect(Collectors.toList());

        /*  위 코드와 동일한 코드
            List<Car> cars = new ArrayList<>();
            for (String carName: carNames) // carNames.stream() 와 같음
            {
                Car car = Car.of(carName); // .map(Car::nameFrom) 와 같음
                cars.add(car);             // .collect(Collectors.toList()); 와 같음
            }
        */

        return new Cars(cars);
    }

    private static void validate(List<String> carNames) {
        // 중복 제거
        Set<String> target = new HashSet<>(carNames);

        if (carNames.size() != target.size()) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_DUPLICATE_ERROR.getErrorMessage());
        }
    }

    public void moveAll() {
        cars.forEach(Car::move);

        /* 아래와 같은 코드
        for(Car car: cars) {
            car.move();
        }
        */
    }

    // "장희권 : ---" 과 "캐스팅 : ---" 과 "기타 : -" 에서 "장희권" 과 "캐스팅" 을 반환하기 위한 함수
    public List<String> getWinnerCars() {
        Car maxCar = getMaxPosition();

        return cars.stream()
                // (람다 인터페이스 사용)
                .filter(car -> car.equalsPosition(maxCar))
                .map(Car::getName)
                .collect(Collectors.toList());

        /* 아래와 같은 기능을 함
        List<String> winners = new ArrayList<>();
        for(Car car: cars) {
            if (car.equalsPosition(maxCar)) {
                winners.add(car.getName());
            }
        }

        return winners;
         */
    }

    private Car getMaxPosition() {

        return cars.stream()
                .max(Car::compareTo)
                .get();

        /* 아래 코드와 같은 기능을 함
        Car maxCar = cars.get(0);
        for (Car car: cars) {
            if (maxCar.compareTo(car) < 0) {
                maxCar = car;
            }
        }

        return maxCar;
        */
    }

    public List<String> getMessages() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}
