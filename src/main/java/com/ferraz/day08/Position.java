package com.ferraz.day08;

public record Position(
        int row,
        int col
) {

    public Position plus(Position otherPosition) {
        return new Position(2 * row - otherPosition.row(), 2 * col - otherPosition.col());
    }

    public boolean isValid(int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public Position copy() {
        return new Position(row, col);
    }
}
