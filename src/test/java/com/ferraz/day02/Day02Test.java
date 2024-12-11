package com.ferraz.day02;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day02Test {

    @Test
    public void testPart1() throws IOException {
        Day day = new Day02();
        Assert.assertEquals(321, day.part1());
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day02();
        Assert.assertEquals(386, day.part2());
    }

}