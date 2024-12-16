package com.ferraz.day06;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day06Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day06(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
                PART1_SAMPLE, 41L,
                PART1, 5242L,
                PART2_SAMPLE, 6L,
                PART2, 1424L
        );
    }

}