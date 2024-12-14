package com.ferraz.day01;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.ferraz.TestUtils.printResults;

public class Day01Test {

    @Test
    public void testPart1Sample() throws IOException {
        Day day = new Day01(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(11, answer);
    }

    @Test
    public void testPart2Sample() throws IOException {
        Day day = new Day01(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(31, answer);
    }

    @Test
    public void testPart1() throws IOException {
        Day day = new Day01(false);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(3569916, answer);
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day01(false);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(26407426, answer);
    }

}