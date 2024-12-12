package com.ferraz.day04;

import com.ferraz.Day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day04 extends Day {

    public Day04() {
        super(4);
    }

    public Day04(boolean useSample) {
        super(4, useSample);
    }

    @Override
    public long part1() throws IOException {
        char[][] lettersMatrix = getLettersMatrix();
        return countWord(lettersMatrix);
    }

    @Override
    public long part2() throws IOException {
        return 0;
    }

    private char[][] getLettersMatrix() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(readInputFile()))) {
            long count = 0;

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            char[][] lettersMatrix = new char[lines.size()][lines.getFirst().length()];

            for(int row = 0; row < lines.size(); row++) {
                lettersMatrix[row] = lines.get(row).toCharArray();
            }

            return lettersMatrix;
        }
    }

    private long countWord(char[][] lettersMatrix) {
        long count = 0;

        for (int row = 0; row < lettersMatrix.length; row++) {
            for (int column = 0; column < lettersMatrix[row].length; column++) {
                char letter = lettersMatrix[row][column];

                if (letter != 'X')
                    continue;

                count += countAllDirectionsFromThisLetter(lettersMatrix, row, column);
            }
        }

        return count;
    }

    private int countAllDirectionsFromThisLetter(char[][] lettersMatrix, int row, int column) {
        int countsFromThisLetter = 0;
        for (int rowIncrease = -1; rowIncrease <= 1; rowIncrease++) {
            for (int columnIncreate = -1; columnIncreate <= 1; columnIncreate++) {
                if (validSequence(lettersMatrix, row, column, rowIncrease, columnIncreate)) {
                    countsFromThisLetter++;
                }
            }
        }
        return countsFromThisLetter;
    }

    private boolean validSequence(char[][] lettersMatrix, int row, int column, int rowIncreate, int columnIncrease) {
        char[] expectedLetters = "MAS".toCharArray();

        for (int i = 1; i <= expectedLetters.length; i++) {
            int actualRow = row + (rowIncreate * i);
            int actualColumn = column + (columnIncrease * i);

            if (actualRow >= lettersMatrix.length || actualColumn >= lettersMatrix[row].length || actualRow < 0 || actualColumn < 0)
                return false;

            if (lettersMatrix[actualRow][actualColumn] != expectedLetters[i - 1])
                return false;
        }

        return true;
    }

}
