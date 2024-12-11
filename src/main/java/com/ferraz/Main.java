package com.ferraz;

import com.ferraz.day01.Day01;
import com.ferraz.day02.Day02;
import com.ferraz.day03.Day03;

import java.io.IOException;
import java.util.List;

public class Main {

    private static List<Day> days =
            List.of(
                    new Day01(),
                    new Day02(),
                    new Day03()
            );

    public static void main(String[] args) throws IOException {
        days.forEach(Day::run);
    }
}