package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.StringJoiner;

import static racingcar.constant.ErrorMessage.CAR_NAME_CONTAINS_SPACE_ERROR;
import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR;

public class Car implements Comparable<Car> {
    private static final int MOVE_LOWER_BOUND = 4;
    private static final int MOVE_SIZE = 1;
    private static final int DEFAULT_POSITION = 0;
    private static final int MAX_NAME_SIZE = 5;
    private static final String NAME_SIZE_DELIMITER = ":";
    private static final String SPACE = " ";

    private final String name;
    private final Position position;

    public Car(String name, Integer position) {
        validate(name);
        this.name = name;
        this.position = new Position(position);
    }

    public static Car nameFrom(String name) {
        return new Car(name, DEFAULT_POSITION);
    }

    private void validate(String name) {
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getErrorMessage());
        }

        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getErrorMessage());
        }

        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(CAR_NAME_CONTAINS_SPACE_ERROR.getErrorMessage());
        }
    }

    public void move() {
        // 랜덤 숫자를 반환하는 건 Car와 직접적인 연관이 있는게 아니므로 RandomGenerator 클래스를 따로 만들어주었다.
        int randomNumber = RandomGenerator.getRandomMoveSize();

        if (randomNumber > MOVE_LOWER_BOUND) {
            position.move(MOVE_SIZE);
        }
    }

    public boolean equalsPosition(Object o) {
        if (this == o)
            return true;

        if (o == null || this.getClass() != o.getClass())
            return false;

        Car targetCar = (Car)o;

        return this.position.equals(targetCar.position);
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position.toString();
    }

    @Override
    public String toString() {

        //SPACE도 넣어서 문자열(한문장)으로 만들어줌
        StringJoiner stringJoiner = new StringJoiner(SPACE);

        stringJoiner.add(name);
        stringJoiner.add(NAME_SIZE_DELIMITER);
        stringJoiner.add(position.toString());

        return stringJoiner.toString();
    }

    @Override
    public int compareTo(Car target) {
        return this.position.compareTo(target.position);
    }
}
