package com.ferraz.day09;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day09Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day09(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
                PART1_SAMPLE, 1928L,
                PART1, 6360094256423L,
                PART2_SAMPLE, -1L,
                PART2, -1L
        );
    }

}