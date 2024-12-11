package com.ferraz.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ferraz.util.Utils.*;

/*
--- Day 2: Red-Nosed Reports ---
Fortunately, the first location The Historians want to search isn't a long walk from the Chief Historian's office.

While the Red-Nosed Reindeer nuclear fusion/fission plant appears to contain no sign of the Chief Historian, the engineers there run up to you as soon as they see you. Apparently, they still talk about the time Rudolph was saved through molecular synthesis from a single electron.

They're quick to add that - since you're already here - they'd really appreciate your help analyzing some unusual data from the Red-Nosed reactor. You turn to check if The Historians are waiting for you, but they seem to have already divided into groups that are currently searching every corner of the facility. You offer to help with the unusual data.

The unusual data (your puzzle input) consists of many reports, one report per line. Each report is a list of numbers called levels that are separated by spaces. For example:

7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
This example data contains six reports each containing five levels.

The engineers are trying to figure out which reports are safe. The Red-Nosed reactor safety systems can only tolerate levels that are either gradually increasing or gradually decreasing. So, a report only counts as safe if both of the following are true:

The levels are either all increasing or all decreasing.
Any two adjacent levels differ by at least one and at most three.
In the example above, the reports can be found safe or unsafe by checking those rules:

7 6 4 2 1: Safe because the levels are all decreasing by 1 or 2.
1 2 7 8 9: Unsafe because 2 7 is an increase of 5.
9 7 6 2 1: Unsafe because 6 2 is a decrease of 4.
1 3 2 4 5: Unsafe because 1 3 is increasing but 3 2 is decreasing.
8 6 4 4 1: Unsafe because 4 4 is neither an increase or a decrease.
1 3 6 7 9: Safe because the levels are all increasing by 1, 2, or 3.
So, in this example, 2 reports are safe.

Analyze the unusual data from the engineers. How many reports are safe?

--- Part Two ---
The engineers are surprised by the low number of safe reports until they realize they forgot to tell you about the Problem Dampener.

The Problem Dampener is a reactor-mounted module that lets the reactor safety systems tolerate a single bad level in what would otherwise be a safe report. It's like the bad level never happened!

Now, the same rules apply as before, except if removing a single level from an unsafe report would make it safe, the report instead counts as safe.

More of the above example's reports are now safe:

7 6 4 2 1: Safe without removing any level.
1 2 7 8 9: Unsafe regardless of which level is removed.
9 7 6 2 1: Unsafe regardless of which level is removed.
1 3 2 4 5: Safe by removing the second level, 3.
8 6 4 4 1: Safe by removing the third level, 4.
1 3 6 7 9: Safe without removing any level.
Thanks to the Problem Dampener, 4 reports are actually safe!

Update your analysis by handling situations where the Problem Dampener can remove a single level from unsafe reports. How many reports are now safe?
 */
public class Day02 {

    public static void main(String[] args) throws IOException {
        initDay(2);

        long initial = initPart(1);
        long answer = part1();
        finishPart(answer, initial);

        initial = initPart(2);
        answer = part2();
        finishPart(answer, initial);

        finishDay();
    }

    // Answer: 321
    public static long part1() throws IOException {
        InputStream inputStream = readInputFile(2);
        return readLines(inputStream, false);
    }

    // Answer: 386
    public static long part2() throws IOException {
        InputStream inputStream = readInputFile(2);
        return readLines(inputStream, true);
    }


    private static int readLines(InputStream inputStream, boolean problemDampener) throws IOException {
        int validReports = 0;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            while((line = reader.readLine()) != null) {
                List<String> values = new ArrayList<>(Arrays.asList(line.split(" ")));
                if (validValues(values, problemDampener))
                    validReports++;
            }

            return validReports;
        }
    }

    private static boolean validValues(List<String> values, boolean problemDampener) {
        boolean lastIncrease = Integer.parseInt(values.get(0)) < Integer.parseInt(values.get(1));

        for (int i = 0; i < values.size() - 1; i++) {
            int value1 = Integer.parseInt(values.get(i));
            int value2 = Integer.parseInt(values.get(i + 1));

            int diff = Math.abs(value1 - value2);
            boolean error = (diff < 1 || diff > 3) || (lastIncrease && value1 > value2) || (!lastIncrease && value1 < value2);

            if (!error)
                continue;

            if (!problemDampener)
                return false;

            return  validValuesRemovingItem(values, i - 1)
                    || validValuesRemovingItem(values, i)
                    || validValuesRemovingItem(values, i + 1);
        }

        return true;
    }

    private static boolean validValuesRemovingItem(List<String> values, int removeItemIndex) {
        if (removeItemIndex < 0)
            return false;

        if (removeItemIndex == values.size() - 1)
            return true;

        List<String> values2 = new ArrayList<>(values);
        values2.remove(removeItemIndex);
        return validValues(values2, false);
    }

}
