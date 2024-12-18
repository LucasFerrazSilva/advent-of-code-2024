package com.ferraz.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class ResonationMap {

    private int rows = 0;
    private int cols = 0;
    private final Map<Character, List<Position>> antennas = new HashMap<>();
    private Set<Position> antinodesPositions;

    public ResonationMap(BufferedReader reader) throws IOException {
        String line;
        while((line = reader.readLine()) != null) {
            char[] charArray = line.toCharArray();
            if (cols == 0) cols = charArray.length;

            for (int col = 0; col < charArray.length; col++) {
                char item = charArray[col];
                if (item != '.') insertAntennaPosition(col, item);
            }

            rows++;
        }
    }

    public long calculateAntinodes(boolean considerResonantHarmonics) {
        antinodesPositions = new HashSet<>();

        for (Entry<Character, List<Position>> antennaPositions: antennas.entrySet()) {
            List<Position> positions = antennaPositions.getValue();

            for (int i = 0; i < positions.size() - 1; i++) {
                for (int j = i+1; j < positions.size(); j++) {
                    calculateAntinodesPositions(considerResonantHarmonics, positions.get(i),  positions.get(j));
                }
            }
        }

        return antinodesPositions.size();
    }

    private void calculateAntinodesPositions(boolean considerResonantHarmonics, Position position1, Position position2) {
        if (considerResonantHarmonics) {
            antinodesPositions.add(position1);
            antinodesPositions.add(position2);
        }

        Position antinode1Position = position1.plus(position2);
        Position antinode2Position = position2.plus(position1);

        if (antinode1Position.isValid(rows, cols)) {
            antinodesPositions.add(antinode1Position);

            if (considerResonantHarmonics) {
                calculateResonantHarmonics(position1, antinode1Position);
            }
        }
        if (antinode2Position.isValid(rows, cols)) {
            antinodesPositions.add(antinode2Position);

            if (considerResonantHarmonics) {
                calculateResonantHarmonics(position2, antinode2Position);
            }
        }
    }

    private void calculateResonantHarmonics(Position lastPosition, Position antinodePosition) {
        while(antinodePosition.isValid(rows, cols)) {
            antinodesPositions.add(antinodePosition);

            Position tempPosition = antinodePosition.copy();
            antinodePosition = antinodePosition.plus(lastPosition);
            lastPosition = tempPosition;
        }
    }

    private void insertAntennaPosition(int col, char item) {
        Position position = new Position(rows, col);
        if (antennas.containsKey(item)) {
            antennas.get(item).add(position);
        } else {
            antennas.put(item, new ArrayList<>(List.of(position)));
        }
    }

    public void print() {
        System.out.print("   ");
        for (int col = 0; col < cols; col++) {
            System.out.printf("%02d ", col);
        }
        System.out.print("\n");

        for (int row = 0; row < rows; row++) {
            System.out.printf("%02d ", row);
            for (int col = 0; col < cols; col++) {
                Position position = new Position(row, col);

                char c = antinodesPositions.contains(position) ? '#' : '.';

                for (Character key: antennas.keySet()) {
                    if (antennas.get(key).contains(position)) {
                        c = key;
                        break;
                    }
                }

                System.out.printf(" %s ", c);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
