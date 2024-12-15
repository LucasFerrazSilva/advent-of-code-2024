package com.ferraz.day06;

import com.ferraz.Day;
import com.ferraz.day05.Day05;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day06Test {

    private Day getDay(boolean useSample) {
        return new Day06(useSample);
    }

    @Test
    public void testPart1Sample() throws IOException {
        Assert.assertEquals(41, getDay(true).part1());
    }
    @Test
    public void testPart1() throws IOException {
        Assert.assertEquals(5242, getDay(false).part1());
    }
    @Test
    public void testPart2Sample() throws IOException {
        Assert.assertEquals(6, getDay(true).part2());
    }
    @Test
    public void testPart2() throws IOException {
        Assert.assertEquals(1424, getDay(false).part2());
    }

}