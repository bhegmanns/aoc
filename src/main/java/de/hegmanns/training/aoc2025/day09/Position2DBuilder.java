package de.hegmanns.training.aoc2025.day09;

import de.hegmanns.training.aoc2025.day04.Position2D;

import java.util.List;

public class Position2DBuilder {

    public static Position2D convertToPositions(String line) {
        String[] split = line.trim().split(",");

        return new Position2D(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}
