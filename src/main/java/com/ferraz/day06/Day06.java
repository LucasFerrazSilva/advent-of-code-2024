package com.ferraz.day06;

import com.ferraz.Day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
--- Day 6: Guard Gallivant ---
The Historians use their fancy device again, this time to whisk you all away to the North Pole prototype suit manufacturing lab... in the year 1518! It turns out that having direct access to history is very convenient for a group of historians.

You still have to be careful of time paradoxes, and so it will be important to avoid anyone from 1518 while The Historians search for the Chief. Unfortunately, a single guard is patrolling this part of the lab.

Maybe you can work out where the guard will go ahead of time so that The Historians can search safely?

You start by making a map (your puzzle input) of the situation. For example:

....#.....
.........#
..........
..#.......
.......#..
..........
.#..^.....
........#.
#.........
......#...
The map shows the current position of the guard with ^ (to indicate the guard is currently facing up from the perspective of the map). Any obstructions - crates, desks, alchemical reactors, etc. - are shown as #.

Lab guards in 1518 follow a very strict patrol protocol which involves repeatedly following these steps:

If there is something directly in front of you, turn right 90 degrees.
Otherwise, take a step forward.
Following the above protocol, the guard moves up several times until she reaches an obstacle (in this case, a pile of failed suit prototypes):

....#.....
....^....#
..........
..#.......
.......#..
..........
.#........
........#.
#.........
......#...
Because there is now an obstacle in front of the guard, she turns right before continuing straight in her new facing direction:

....#.....
........>#
..........
..#.......
.......#..
..........
.#........
........#.
#.........
......#...
Reaching another obstacle (a spool of several very long polymers), she turns right again and continues downward:

....#.....
.........#
..........
..#.......
.......#..
..........
.#......v.
........#.
#.........
......#...
This process continues for a while, but the guard eventually leaves the mapped area (after walking past a tank of universal solvent):

....#.....
.........#
..........
..#.......
.......#..
..........
.#........
........#.
#.........
......#v..
By predicting the guard's route, you can determine which specific positions in the lab will be in the patrol path. Including the guard's starting position, the positions visited by the guard before leaving the area are marked with an X:

....#.....
....XXXXX#
....X...X.
..#.X...X.
..XXXXX#X.
..X.X.X.X.
.#XXXXXXX.
.XXXXXXX#.
#XXXXXXX..
......#X..
In this example, the guard will visit 41 distinct positions on your map.

Predict the path of the guard. How many distinct positions will the guard visit before leaving the mapped area?
 */
public class Day06 extends Day {

    public Day06() {
        super(6);
    }

    public Day06(boolean useSample) {
        super(6, useSample);
    }

    @Override
    public long part1() throws IOException {
        return execute(false);
    }

    @Override
    public long part2() throws IOException {
        return execute(true);
    }

    private long execute(boolean hardModeParam) throws IOException {
        GuardManager guardManager = new GuardManager(getPositions());
        Set<Position> distinctPositionsUsed = new HashSet<>();
        distinctPositionsUsed.add(guardManager.getPosition());

        while(guardManager.isInsideTheArea()) {
            if (guardManager.nextPositionIsBlocked()) {
                guardManager.turn();
            }
            distinctPositionsUsed.add(guardManager.move());
        }

        return distinctPositionsUsed.size();
    }

    private char[][] getPositions() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(readInputFile()))) {
            List<char[]> lines = new ArrayList<>();

            String line;
            while((line = reader.readLine()) != null) {
                lines.add(line.toCharArray());
            }

            return lines.toArray(new char[lines.size()][lines.getFirst().length]);
        }
    }

}
