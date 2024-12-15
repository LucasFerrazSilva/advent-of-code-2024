package com.ferraz.day01;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day01Test {

    private Day getDay(boolean useSample) {
        return new Day01(useSample);
    }

    @Test
    public void testPart1Sample() throws IOException {
        Assert.assertEquals(11, getDay(true).part1());
    }

    @Test
    public void testPart1() throws IOException {
        Assert.assertEquals(3569916, getDay(false).part1());
    }

    @Test
    public void testPart2Sample() throws IOException {
        Assert.assertEquals(31, getDay(true).part2());
    }

    @Test
    public void testPart2() throws IOException {
        Assert.assertEquals(26407426, getDay(false).part2());
    }

}