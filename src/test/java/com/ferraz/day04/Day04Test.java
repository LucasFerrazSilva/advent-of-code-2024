package com.ferraz.day04;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.ferraz.TestUtils.printResults;

public class Day04Test {

    @Test
    public void testPart1Sample() throws IOException {
        Day day = new Day04(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(18, answer);
    }

    @Test
    public void testPart2Sample() throws IOException {
        Day day = new Day04(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(9, answer);
    }

    @Test
    public void testPart1() throws IOException {
        Day day = new Day04();
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(2493, answer);
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day04();
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(1890, answer);
    }

}