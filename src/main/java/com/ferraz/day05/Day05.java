package com.ferraz.day05;

import com.ferraz.Day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Day05 extends Day {

    public Day05() {
        super(5);
    }

    public Day05(boolean useSample) {
        super(5, useSample);
    }

    @Override
    public long part1() throws IOException {
        return execute();
    }

    @Override
    public long part2() throws IOException {
        return 0;
    }

    private long execute() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(readInputFile()))) {
            Map<Integer, Set<Integer>> rulesForNumber = getRulesForNumber(reader);

            long sum = 0;

            String update;
            while((update = reader.readLine()) != null) {
                List<Integer> numbers = getNumbers(update);

                if (isValidUpdate(numbers, rulesForNumber)) {
                    int middleIndex = numbers.size() / 2;
                    sum += numbers.get(middleIndex);
                }
            }

            return sum;
        }
    }

    private static List<Integer> getNumbers(String update) {
        return Stream.of(update.split(",")).map(Integer::parseInt).toList();
    }

    private boolean isValidUpdate(List<Integer> numbers, Map<Integer, Set<Integer>> rulesForNumber) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (contains(rulesForNumber, numbers.get(j), numbers.get(i)))
                    return false;
            }
        }
        return true;
    }

    private boolean contains(Map<Integer, Set<Integer>> rulesForNumberMap, int key, int value) {
        return rulesForNumberMap.containsKey(key) && rulesForNumberMap.get(key).contains(value);
    }

    private Map<Integer, Set<Integer>> getRulesForNumber(BufferedReader reader) throws IOException {
        Map<Integer, Set<Integer>> rulesForNumberMap = new HashMap<>();
        String line;
        while((line = reader.readLine()) != null) {
            if (line.isBlank())
                break;

            String[] values = line.split("\\|");
            int key = Integer.parseInt(values[0]);
            int value = Integer.parseInt(values[1]);

            if (rulesForNumberMap.containsKey(key)) {
                rulesForNumberMap.get(key).add(value);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(value);
                rulesForNumberMap.put(key, set);
            }
        }
        return rulesForNumberMap;
    }



}
