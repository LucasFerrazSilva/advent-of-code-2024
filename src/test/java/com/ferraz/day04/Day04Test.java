package com.ferraz.day04;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day04Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day04(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
                PART1_SAMPLE, 18L,
                PART1, 2493L,
                PART2_SAMPLE, 9L,
                PART2, 1890L
        );
    }

}