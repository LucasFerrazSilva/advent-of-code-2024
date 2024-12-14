package com.ferraz.day06;

public class Area {

    private final char[][] matrix;
    private final Position initialPosition;
    private static final char BLOCK_SYMBOL = '#';
    private static final char NO_BLOCK_SYMBOL = '.';


    public Area(char[][] matrix, Position initialPosition) {
        this.matrix = matrix;
        this.initialPosition = initialPosition;
    }

    public int getNumberOfRows() {
        return matrix.length;
    }

    public int getNumberOfColumns() {
        return matrix[0].length;
    }

    public boolean hasBlockAt(Position position) {
        return contains(position) && matrix[position.row()][position.column()] == BLOCK_SYMBOL;
    }


    public boolean contains(Position position) {
        return 0 <= position.row() && position.row() < getNumberOfRows()
                && 0 <= position.column() && position.column() < getNumberOfColumns();
    }

    public void insertBlockAt(Position position) {
        matrix[position.row()][position.column()] = BLOCK_SYMBOL;
    }

    public void removeBlockAt(Position position) {
        matrix[position.row()][position.column()] = NO_BLOCK_SYMBOL;
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public PositionDirection getInitialPositionDirection() {
        return new PositionDirection(initialPosition, Direction.UP);
    }
}
