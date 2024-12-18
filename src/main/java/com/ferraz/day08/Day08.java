package com.ferraz.day08;

import com.ferraz.Day;

import java.io.BufferedReader;
import java.io.IOException;

public class Day08 extends Day {

    private ResonationMap resonationMap;

    public Day08(boolean useSample) {
        super(useSample);
    }

    @Override
    public int getDay() {
        return 8;
    }

    @Override
    protected long execute(boolean considerResonantHarmonics, BufferedReader reader) throws IOException {
        resonationMap = new ResonationMap(reader);
        return resonationMap.calculateAntinodes(considerResonantHarmonics);
    }

    @Override
    public void print() {
        resonationMap.print();
    }

}
