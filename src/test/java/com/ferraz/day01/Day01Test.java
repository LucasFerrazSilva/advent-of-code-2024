package com.ferraz.day01;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day01Test {

    @Test
    public void testPart1() throws IOException {
        Day day = new Day01();
        Assert.assertEquals(3569916, day.part1());
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day01();
        Assert.assertEquals(26407426, day.part2());
    }

}