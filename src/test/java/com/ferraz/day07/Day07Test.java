package com.ferraz.day07;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day07Test {

    private Day getDay(boolean useSample) {
        return new Day07(useSample);
    }

    @Test
    public void testPart1Sample() throws IOException {
        Assert.assertEquals(3749, getDay(true).part1());
    }
    @Test
    public void testPart1() throws IOException {
        Assert.assertEquals(-1, getDay(false).part1());
    }
    @Test
    public void testPart2Sample() throws IOException {
        Assert.assertEquals(-1, getDay(true).part2());
    }
    @Test
    public void testPart2() throws IOException {
        Assert.assertEquals(-1, getDay(false).part2());
    }

}