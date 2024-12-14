package com.ferraz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Day {

    private final boolean useSample;

    protected Day(boolean useSample) {
        this.useSample = useSample;
    }

    public void run() {
        try {
            initDay();

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

    public abstract int getDay();
    protected abstract long execute(boolean hardModeParam, BufferedReader reader) throws IOException;

    public long part1() throws IOException {
        return prepareExecute(false);
    }

    public long part2() throws IOException {
        return prepareExecute(true);
    }

    protected long prepareExecute(boolean hardModeParam) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(readInputFile()))) {
            return execute(hardModeParam, reader);
        }
    }

    protected void initDay() {
        System.out.printf("%n--==< Dia %02d >==--%n%n", getDay());
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
        String fileName = (useSample ? "inputs/day%02d_sample.txt" : "inputs/day%02d.txt").formatted(getDay());
        return classloader.getResourceAsStream(fileName);
    }

}
