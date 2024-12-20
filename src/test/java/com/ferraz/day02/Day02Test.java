package com.ferraz.day02;

import com.ferraz.Day;
import com.ferraz.DayPart;
import com.ferraz.DayTest;

import java.util.Map;

import static com.ferraz.DayPart.*;

public class Day02Test extends DayTest {

    @Override
    public Day getDay(boolean useSample) {
        return new Day02(useSample);
    }

    @Override
    public Map<DayPart, Long> getResults() {
        return Map.of(
                PART1_SAMPLE, 2L,
                PART1, 321L,
                PART2_SAMPLE, 4L,
                PART2, 386L
        );
    }

}