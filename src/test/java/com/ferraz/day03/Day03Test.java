package com.ferraz.day03;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.ferraz.TestUtils.printResults;

public class Day03Test {

    @Test
    public void testPart1Sample() throws IOException {
        Day day = new Day03(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(161, answer);
    }

    @Test
    public void testPart2Sample() throws IOException {
        Day day = new Day03(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(48, answer);
    }

    @Test
    public void testPart1() throws IOException {
        Day day = new Day03(false);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(184122457, answer);
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day03(false);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(107862689, answer);
    }

}