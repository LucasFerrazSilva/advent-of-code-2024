package com.ferraz.day06;

public class PositionDirection {

    private final Position position;
    private final Direction direction;


    public PositionDirection(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }


    public Position getNextPosition() {
        return position.move(direction);
    }

    public boolean isInside(Area area) {
        return area.contains(position);
    }

    public boolean cantMoveForwardIn(Area area) {
        Position nextPosition = position.move(direction);
        return area.hasBlockAt(nextPosition);
    }

    public PositionDirection turn() {
        return new PositionDirection(position, direction.getNextDirection());
    }

    public PositionDirection move() {
        return new PositionDirection(position.move(direction), direction);
    }


    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PositionDirection other))
            return false;

        return this.direction.equals(other.direction) && this.position.equals(other.position);
    }

    @Override
    public int hashCode() {
        return this.direction.hashCode() + this.position.hashCode();
    }

    public PositionDirection copy() {
        return new PositionDirection(position, direction);
    }
}
