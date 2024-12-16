package com.ferraz.day03;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day03Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day03(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
                PART1_SAMPLE, 161L,
                PART1, 184122457L,
                PART2_SAMPLE, 48L,
                PART2, 107862689L
        );
    }

}