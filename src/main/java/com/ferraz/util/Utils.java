package com.ferraz.util;

import java.io.InputStream;

public class Utils {

    public static void initDay(int day) {
        System.out.printf("%n--==< Dia %02d >==--%n%n", day);
    }

    public static void finishDay() {
        System.out.println("--==============--");
    }

    public static long initPart(int part) {
        System.out.printf("-- Parte %d --%n", part);
        return System.currentTimeMillis();
    }

    public static void finishPart(long answer, long initialTime) {
        long endingTime = System.currentTimeMillis();
        System.out.println("Resposta: " + answer);
        System.out.printf("Tempo total: %d ms %n%n", endingTime - initialTime);
    }

    public static InputStream readInputFile(int day) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResourceAsStream("inputs/day%2d.txt".formatted(day));
    }

}
