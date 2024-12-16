package com.ferraz.day07;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day07Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day07(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
                PART1_SAMPLE, 3749L,
                PART1, 1545311493300L,
                PART2_SAMPLE, 11387L,
                PART2, 169122112716571L
        );
    }

}