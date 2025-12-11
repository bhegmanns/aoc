package de.hegmanns.training.aoc2025;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc.common.Pair;
import de.hegmanns.training.aoc.common.Position3D;
import de.hegmanns.training.aoc2025.day04.Position2D;
import de.hegmanns.training.aoc2025.day09.Position2DBuilder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day09 {

    public final static String FILE_PATH = "aoc2025/task09.txt";

    static void main() {
        List<String> lines = AocFileLoader.loadLines(FILE_PATH);

        System.out.println("Solution Day09 part 1: " + task1(lines));
        System.out.println("Solution Day09 part 2: " + task2(lines));
    }

    private static List<Position3D> convertToPositions(List<String> lines) {
        return lines.stream().map(Position3D::readDefinitionStringIntoPosition).toList();
    }

    public static long task1(List<String> lines) {
        List<Position2D> positions = lines.stream().map(Position2DBuilder::convertToPositions).toList();

        long maxArea = 0L;

        for (Position2D from : positions) {
            for (Position2D to : positions) {
                long area = (Math.abs((long)from.xPosition()-to.xPosition()) + 1) * (Math.abs((long)from.yPosition()-to.yPosition())+1);
                System.out.println(">" + from + ".." + to + ": " + area);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }



        return maxArea;
    }

    public static long task2(List<String> lines) {
        return 0L;
    }
}
