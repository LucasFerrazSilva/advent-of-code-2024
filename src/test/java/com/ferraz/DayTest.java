package com.ferraz;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class DayTest {

    public abstract Day getDay(boolean useSample);
    public abstract Map<DayPart, Long> getResults();

    @Test
    public void testPart1Sample() throws IOException {
        Assert.assertEquals(getResults().get(DayPart.PART1_SAMPLE), (Long) getDay(true).part1());
    }

    @Test
    public void testPart1_Real() throws IOException {
        Assert.assertEquals(getResults().get(DayPart.PART1), (Long) getDay(false).part1());
    }

    @Test
    public void testPart2Sample() throws IOException {
        Assert.assertEquals(getResults().get(DayPart.PART2_SAMPLE), (Long) getDay(true).part2());
    }

    @Test
    public void testPart2_Real() throws IOException {
        Assert.assertEquals(getResults().get(DayPart.PART2), (Long) getDay(false).part2());
    }

}
