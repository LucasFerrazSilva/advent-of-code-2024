package com.ferraz.day05;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day05Test {

    private Day getDay(boolean useSample) {
        return new Day05(useSample);
    }

    @Test
    public void testPart1Sample() throws IOException {
        Assert.assertEquals(143, getDay(true).part1());
    }
    @Test
    public void testPart1() throws IOException {
        Assert.assertEquals(4790, getDay(false).part1());
    }
    @Test
    public void testPart2Sample() throws IOException {
        Assert.assertEquals(123, getDay(true).part2());
    }
    @Test
    public void testPart2() throws IOException {
        Assert.assertEquals(6319, getDay(false).part2());
    }

}