package com.ferraz.day03;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.ferraz.TestUtils.printResults;

public class Day03Test {

    @Test
    public void testPart1() throws IOException {
        Day day = new Day03();
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(184122457, answer);
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day03();
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(0, answer);
    }

}