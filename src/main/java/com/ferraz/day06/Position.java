package com.ferraz.day06;

public record Position(int row, int column) {

    public Position move(Direction direction) {
        return new Position(this.row + direction.getRowDisplacement(), this.column + direction.getColumnDisplacement());
    }

}
