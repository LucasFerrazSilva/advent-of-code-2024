package com.ferraz;

import java.io.IOException;
import java.io.InputStream;

public abstract class Day {

    protected final int day;

    protected Day(int day) {
        this.day = day;
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
        String fileName = "inputs/day%02d.txt".formatted(day);
        return classloader.getResourceAsStream(fileName);
    }

}
