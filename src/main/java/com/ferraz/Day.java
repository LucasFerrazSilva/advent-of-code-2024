package com.ferraz;

import java.io.IOException;
import java.io.InputStream;

public abstract class Day {

    protected final int day;
    private final boolean useSample;

    protected Day(int day) {
        this(day, false);
    }
    protected Day(int day, boolean useSample) {
        this.day = day;
        this.useSample = useSample;
    }

    public void run() {
        try {
            initDay(day);

            long initial = initPart(1);
            long answer = part1();
            finishPart(answer, initial);

            initial = initPart(2);
            answer = part2();
            finishPart(answer, initial);

            finishDay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract long part1() throws IOException;
    public abstract long part2() throws IOException;

    protected void initDay(int day) {
        System.out.printf("%n--==< Dia %02d >==--%n%n", day);
    }

    protected void finishDay() {
        System.out.println("--==============--");
    }

    protected long initPart(int part) {
        System.out.printf("-- Parte %d --%n", part);
        return System.currentTimeMillis();
    }

    protected void finishPart(long answer, long initialTime) {
        long endingTime = System.currentTimeMillis();
        System.out.println("Resposta: " + answer);
        System.out.printf("Tempo total: %d ms %n%n", endingTime - initialTime);
    }

    protected InputStream readInputFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String fileName = (useSample ? "inputs/day%02d_sample.txt" : "inputs/day%02d.txt").formatted(day);
        return classloader.getResourceAsStream(fileName);
    }

}
