package com.ferraz.day04;

import com.ferraz.Day;
import com.ferraz.day03.Day03;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.ferraz.TestUtils.printResults;

public class Day04Test extends TestCase {

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
        Assert.assertEquals(0, answer);
    }

    @Test
    public void testPart1() throws IOException {
        Day day = new Day04();
        long initialTime = System.currentTimeMillis();
        long answer = day.part1();
        printResults(answer, initialTime);
        Assert.assertEquals(0, answer);
    }

    @Test
    public void testPart2() throws IOException {
        Day day = new Day04();
        long initialTime = System.currentTimeMillis();
        long answer = day.part2();
        printResults(answer, initialTime);
        Assert.assertEquals(0, answer);
    }

}