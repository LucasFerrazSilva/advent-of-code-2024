package com.ferraz.day05;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day05Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day05(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
                PART1_SAMPLE, 143L,
                PART1, 4790L,
                PART2_SAMPLE, 123L,
                PART2, 6319L
        );
    }

}