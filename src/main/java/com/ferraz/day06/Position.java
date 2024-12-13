package com.ferraz.day06;

public class Position {

    private final int row;
    private final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position move(Direction direction) {
        return new Position(this.row + direction.getRowDisplacement(), this.column + direction.getColumnDisplacement());
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (!(object instanceof Position other))
            return false;

        return this.getRow() == other.getRow() && this.getColumn() == other.getColumn();
    }

    @Override
    public final int hashCode() {
        return row * 10000000 + column;
    }

}
