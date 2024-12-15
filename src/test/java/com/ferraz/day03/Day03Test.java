package com.ferraz.day03;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day03Test {

    private Day getDay(boolean useSample) {
        return new Day03(useSample);
    }

    @Test
    public void testPart1Sample() throws IOException {
        Assert.assertEquals(161, getDay(true).part1());
    }
    @Test
    public void testPart1() throws IOException {
        Assert.assertEquals(184122457, getDay(false).part1());
    }
    @Test
    public void testPart2Sample() throws IOException {
        Assert.assertEquals(48, getDay(true).part2());
    }
    @Test
    public void testPart2() throws IOException {
        Assert.assertEquals(107862689, getDay(false).part2());
    }

}