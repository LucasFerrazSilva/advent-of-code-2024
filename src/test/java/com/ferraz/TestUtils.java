package com.ferraz;

public class TestUtils {

    public static void printResults(long answer, long initialTime) {
        long endingTime = System.currentTimeMillis();
        System.out.println("Resposta: " + answer);
        System.out.printf("Tempo total: %d ms %n%n", endingTime - initialTime);
    }

}
