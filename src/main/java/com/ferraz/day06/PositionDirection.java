package com.ferraz.day06;

public record PositionDirection(Position position, Direction direction) {

    public boolean isInside(AreaMap areaMap) {
        return areaMap.isValid(position);
    }

    public boolean cantMoveForward(AreaMap areaMap) {
        Position nextPosition = position.move(direction);
        return areaMap.hasBlockAt(nextPosition);
    }

    public PositionDirection turn() {
        return new PositionDirection(position, direction.getNextDirection());
    }

    public PositionDirection move() {
        return new PositionDirection(position.move(direction), direction);
    }

}
