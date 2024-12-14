package com.ferraz.day06;

public record Position(int row, int column) {

    public Position move(Direction direction) {
        return new Position(this.row + direction.getRowDisplacement(), this.column + direction.getColumnDisplacement());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (!(object instanceof Position other))
            return false;

        return this.row() == other.row && this.column() == other.column;
    }

    @Override
    public String toString() {
        return "Position[row=%d, column=%d]".formatted(row, column);
    }

}
