package com.ferraz.day02;

import com.ferraz.Day;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.ferraz.TestUtils.printResults;

public class Day02Test {

    @Test
    public void testPart1Sample() throws IOException {
        Day day = new Day02(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(2, answer);
    }

    @Test
    public void testPart2Sample() throws IOException {
        Day day = new Day02(true);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(4, answer);
    }

    @Test
    public void testPart1() throws IOException {
        Day day = new Day02(false);
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(321, answer);
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day02(false);
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(386, answer);
    }

}