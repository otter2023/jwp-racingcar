package racingcar.utils;

public class RandomGenerator {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    public static int getRandomMoveSize() {
        return (int) (Math.random() * 10);
    }
}