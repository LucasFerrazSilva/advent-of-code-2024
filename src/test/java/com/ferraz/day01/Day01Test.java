package com.ferraz.day01;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day01Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day01(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
            PART1_SAMPLE, 11L,
            PART1, 3569916L,
            PART2_SAMPLE, 31L,
            PART2, 26407426L
        );
    }

}