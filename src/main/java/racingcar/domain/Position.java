package racingcar.domain;

public class Position implements Comparable<Position> {
    private static final String POSITION_STRING = "-";

    private Integer position;

    public Position(Integer position) {
        this.position = position;
    }

    public void move(int go) {
        position += go;
    }

    @Override
    public String toString() {
        return POSITION_STRING.repeat(position);
    }

    @Override
    public int compareTo(Position targetPosition) {
        return this.position - targetPosition.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || this.getClass() != o.getClass())
            return false;

        Position targetPosition = (Position)o;

        return this.position.equals(targetPosition.position);
    }
}
