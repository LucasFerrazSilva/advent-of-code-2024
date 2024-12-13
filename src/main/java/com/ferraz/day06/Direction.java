package com.ferraz.day06;

public enum Direction {

    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    private final int rowDisplacement;
    private final int columnDisplacement;

    Direction(int rowDisplacement, int columnDisplacement) {
        this.rowDisplacement = rowDisplacement;
        this.columnDisplacement = columnDisplacement;
    }

    public int getRowDisplacement() {
        return rowDisplacement;
    }

    public int getColumnDisplacement() {
        return columnDisplacement;
    }

    public Direction getNextDirection() {
        return switch(this) {
            case UP -> RIGHT;
            case RIGHT -> DOWN;
            case DOWN -> LEFT;
            case LEFT -> UP;
        };
    }
}
