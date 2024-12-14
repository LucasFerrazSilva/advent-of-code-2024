package com.ferraz.day04;

import com.ferraz.Day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day04 extends Day {

    public Day04(boolean useSample) {
        super(useSample);
    }

    @Override
    public int getDay() {
        return 4;
    }

    @Override
    protected long execute(boolean xFactor) throws IOException {
        char[][] lettersMatrix = getLettersMatrix();

        long count = 0;

        char initialLetter = xFactor ? 'A' : 'X';

        for (int row = 0; row < lettersMatrix.length; row++) {
            for (int column = 0; column < lettersMatrix[row].length; column++) {
                char letter = lettersMatrix[row][column];

                if (letter != initialLetter)
                    continue;

                if (xFactor) {
                    count += isXMas(lettersMatrix, row, column) ? 1 : 0;
                } else {
                    count += countAllDirectionsFromThisLetter(lettersMatrix, row, column);
                }
            }
        }

        return count;
    }

    private char[][] getLettersMatrix() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(readInputFile()))) {
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

    private boolean isXMas(char[][] letters, int row, int column) {
        if (row <= 0 || row >= letters.length - 1 || column <= 0 || column >= letters[row].length - 1)
            return false;

        int left = -1;
        int right = +1;

        return foundStartingFrom(left, letters, row, column) && foundStartingFrom(right, letters, row, column);
    }

    private boolean foundStartingFrom(int j, char[][] lettersMatrix, int row, int column) {
        return (lettersMatrix[row+1][column+j] == 'M' && lettersMatrix[row-1][column-j] == 'S')
                || (lettersMatrix[row-1][column-j] == 'M' && lettersMatrix[row+1][column+j] == 'S');
    }

    private int countAllDirectionsFromThisLetter(char[][] lettersMatrix, int row, int column) {
        int countsFromThisLetter = 0;
        for (int rowIncrease = -1; rowIncrease <= 1; rowIncrease++) { // cima -> meio -> baixo
            for (int columnIncreate = -1; columnIncreate <= 1; columnIncreate++) { // esquerda -> meio -> direita
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
