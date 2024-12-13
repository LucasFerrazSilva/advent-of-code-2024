package com.ferraz.day06;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.ferraz.TestUtils.printResults;

public class Day06Test {

    @Test
    public void testPart1Sample() throws IOException {
        Day day = new Day06(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(41, answer);
    }

    @Test
    public void testPart1() throws IOException {
        Day day = new Day06();
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(5242, answer);
    }

    @Test
    public void testPart2Sample() throws IOException {
        Day day = new Day06(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(-1, answer);
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day06();
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(-1, answer);
    }

}