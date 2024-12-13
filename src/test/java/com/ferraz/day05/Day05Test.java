package com.ferraz.day05;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.ferraz.TestUtils.printResults;

public class Day05Test {

    @Test
    public void testPart1Sample() throws IOException {
        Day day = new Day05(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(143, answer);
    }

    @Test
    public void testPart1() throws IOException {
        Day day = new Day05();
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(4790, answer);
    }

    @Test
    public void testPart2Sample() throws IOException {
        Day day = new Day05(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(123, answer);
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day05();
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(6319, answer);
    }

}