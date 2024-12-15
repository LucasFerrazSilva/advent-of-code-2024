package com.ferraz.day07;

import com.ferraz.Day;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day07 extends Day {

    public Day07(boolean useSample) {
        super(useSample);
    }

    @Override
    public int getDay() {
        return 7;
    }

    @Override
    protected long execute(boolean useCombineOperator, BufferedReader reader) throws IOException {
        return getNumbers(reader).stream()
                .filter(row -> isValidRow(row, useCombineOperator))
                .mapToLong(List::getFirst).sum();
    }

    private boolean isValidRow(List<Long> row, boolean useCombineOperator) {
        Long result = row.getFirst();
        List<Long> numbers = row.subList(1, row.size());
        char[] operators = initOperators(numbers);
        int base = useCombineOperator ? 3 : 2;

        for(int n = 0; n < Math.pow(base, operators.length); n++) {
            long attempt = calculateAttempt(numbers, operators);
            if (attempt == result) return true;
            rearrangeOperators(operators, useCombineOperator);
        }

        return false;
    }

    private char[] initOperators(List<Long> numbers) {
        char[] operators = new char[numbers.size() - 1];
        Arrays.fill(operators, '+');
        return operators;
    }

    private long calculateAttempt(List<Long> numbers, char[] operators) {
        long attempt = numbers.getFirst();

        for (int i = 1; i < numbers.size(); i++) {
            long number = numbers.get(i);
            attempt = switch(operators[i - 1]) {
                case '+' -> attempt + number;
                case '*' -> attempt * number;
                case '|' -> Long.parseLong(attempt + "" + number);
                default -> throw new IllegalStateException("Unexpected value: " + operators[i - 1]);
            };
        }

        return attempt;
    }

    private void rearrangeOperators(char[] operators, boolean useCombineOperator) {
        for (int i = 0; i < operators.length; i++) {
            operators[i] = switch (operators[i]) {
                case '+' -> '*';
                case '*' -> useCombineOperator ? '|' : '+';
                case '|' -> '+';
                default -> throw new IllegalStateException("Unexpected value: " + operators[i]);
            };

            if (operators[i] != '+')
                break;
        }
    }

    private List<List<Long>> getNumbers(BufferedReader reader) throws IOException {
        List<List<Long>> numbers = new ArrayList<>();

        String line;
        while((line = reader.readLine()) != null) {
            numbers.add(Stream.of(line.split(":?\\s")).map(Long::parseLong).toList());
        }

        return numbers;
    }

}
