package com.ferraz.day02;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day02Test {

    private Day getDay(boolean useSample) {
        return new Day02(useSample);
    }

    @Test
    public void testPart1Sample() throws IOException {
        Assert.assertEquals(2, getDay(true).part1());
    }
    @Test
    public void testPart1() throws IOException {
        Assert.assertEquals(321, getDay(false).part1());
    }
    @Test
    public void testPart2Sample() throws IOException {
        Assert.assertEquals(4, getDay(true).part2());
    }
    @Test
    public void testPart2() throws IOException {
        Assert.assertEquals(386, getDay(false).part2());
    }

}