package com.ferraz.day06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuardManager {

    private char[][] positions;
    private Position position;
    private Position initPosition;
    private Direction direction;
    private Set<Position> positionsUsed;
    private List<PositionDirection> positionsDirectionsUsed;
    private Set<Position> validObstructionPositions;

    public GuardManager(char[][] positions, Position initialPosition) {
        this.positions = positions;
        this.position = initialPosition;
        this.initPosition = initialPosition;
        this.direction = Direction.UP;
        this.positionsUsed = new HashSet<>();
        this.positionsUsed.add(this.position);
        this.positionsDirectionsUsed = new ArrayList<>();
        this.positionsDirectionsUsed.add(new PositionDirection(this.position, this.direction));
        this.validObstructionPositions = new HashSet<>();
    }

    public Position getInitPosition() {
        return initPosition;
    }

    public char getCharAtPosition(Position nextPosition) {
        return this.positions[nextPosition.row()][nextPosition.column()];
    }

    public boolean nextPositionIsBlocked() {
        return positionIsBlocked(this.position.move(this.direction));
    }

    public boolean positionIsBlocked(Position nextPosition) {
        return getCharAtPosition(nextPosition) == '#';
    }

    public void move() {
        this.position = position.move(this.direction);
    }

    public void turn() {
        this.direction = direction.getNextDirection();
    }

    public boolean isInsideTheArea() {
        return isInsideTheArea(this.position.move(this.direction));
    }

    public boolean isInsideTheArea(Position nextPosition) {
        int row = nextPosition.row();
        int col = nextPosition.column();
        return row >= 0 && row < this.positions.length && col >= 0 && col < this.positions[0].length;
    }

    public void testIfBlockNextPositionIsValidObstruction() {
        PositionDirection actualPositionDirection = new PositionDirection(this.position, this.direction);

        Position nextPosition = actualPositionDirection.getNextPosition();
        if (!isInsideTheArea(nextPosition) || nextPositionIsBlocked() || positionsUsed.contains(nextPosition))
            return;

        addBlock(nextPosition);
        boolean validBlock = walk(true);
        removeBlock(nextPosition);

        this.position = actualPositionDirection.getPosition();
        this.direction = actualPositionDirection.getDirection();

        if (validBlock) {
            validObstructionPositions.add(nextPosition);
            System.out.println(actualPositionDirection);
        }

    }

    public long getValidObstructionPositions() {
        return validObstructionPositions.size();
    }

    public void addBlock(Position position) {
        this.positions[position.row()][position.column()] = '#';
    }

    public void removeBlock(Position nextPosition) {
        this.positions[nextPosition.row()][nextPosition.column()] = '.';
    }

    public long getNumberOfPositionsUsed() {
        return positionsUsed.size();
    }

    public Set<Position> getPositionsUsed() {
        return positionsUsed;
    }

    public List<PositionDirection> getPositionsDirectionsUsed() {
        return positionsDirectionsUsed;
    }

    public boolean walk() {
        return this.walk(false);
    }

    public boolean walk(boolean checkVisitedPosition) {
        Set<PositionDirection> positionsDirections = new HashSet<>();

        while(isInsideTheArea()) {
            if (nextPositionIsBlocked()) {
                turn();
            }
            move();

            PositionDirection positionDirection = new PositionDirection(this.position, this.direction);

            if (checkVisitedPosition) {
                if (positionsDirections.contains(positionDirection))
                    return true;

                positionsDirections.add(positionDirection);
            } else {
                positionsUsed.add(this.position);
                positionsDirectionsUsed.add(positionDirection);
            }
        }
        return false;
    }
}
