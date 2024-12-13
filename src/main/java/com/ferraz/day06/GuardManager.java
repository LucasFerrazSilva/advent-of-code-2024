package com.ferraz.day06;

public class GuardManager {

    private char[][] positions;
    private Position position;
    private Direction direction;

    public GuardManager(char[][] positions) {
        this.positions = positions;
        this.position = getInitialPosition();
        this.direction = Direction.UP;
    }

    private Position getInitialPosition() {
        for (int row = 0; row < positions.length; row++) {
            for (int col = 0; col < positions[0].length; col++) {
                if (positions[row][col] == '^')
                    return new Position(row,col);
            }
        }
        throw new RuntimeException("Posição inicial não encontrada");
    }

    public char getCharAtPosition(Position nextPosition) {
        return this.positions[nextPosition.getRow()][nextPosition.getColumn()];
    }

    public boolean nextPositionIsBlocked() {
        Position nextPosition = this.position.move(this.direction);
        return getCharAtPosition(nextPosition) == '#';
    }

    public Position move() {
        this.position = position.move(direction);
        return this.position;
    }

    public void turn() {
        this.direction = direction.getNextDirection();
    }

    public boolean isInsideTheArea() {
        Position nextPosition = this.position.move(this.direction);
        int row = nextPosition.getRow();
        int col = nextPosition.getColumn();
        return row >= 0 && row < this.positions.length && col >= 0 && col < this.positions[0].length;
    }

    public Position getPosition() {
        return this.position;
    }

}
