package com.ferraz.day08;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day08Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day08(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
                PART1_SAMPLE, 14L,
                PART1, -1L,
                PART2_SAMPLE, -1L,
                PART2, -1L
        );
    }

}