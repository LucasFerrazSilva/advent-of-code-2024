package com.ferraz.day04;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day04Test {

    private Day getDay(boolean useSample) {
        return new Day04(useSample);
    }

    @Test
    public void testPart1Sample() throws IOException {
        Assert.assertEquals(18, getDay(true).part1());
    }
    @Test
    public void testPart1() throws IOException {
        Assert.assertEquals(2493, getDay(false).part1());
    }
    @Test
    public void testPart2Sample() throws IOException {
        Assert.assertEquals(9, getDay(true).part2());
    }
    @Test
    public void testPart2() throws IOException {
        Assert.assertEquals(1890, getDay(false).part2());
    }

}