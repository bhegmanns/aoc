package de.hegmanns.training.aoc2025;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc.common.Pair;
import de.hegmanns.training.aoc.common.Position3D;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day08 {

    public final static String FILE_PATH = "aoc2025/task08.txt";

    static void main() {
        List<String> lines = AocFileLoader.loadLines(FILE_PATH);

        System.out.println("Solution Day08 part 1: " + task1(lines));
        System.out.println("Solution Day08 part 2: " + task2(lines));
    }

    private static List<Position3D> convertToPositions(List<String> lines) {
        return lines.stream().map(Position3D::readDefinitionStringIntoPosition).toList();
    }
    public static long task1(List<String> lines) {
        List<Position3D> position3DS = convertToPositions(lines);

        Map<Pair<Position3D>, BigDecimal> distances = new HashMap<>();

        for (Position3D position3D : position3DS) {
            for (Position3D toPosition3D : position3DS) {
                if (!position3D.equals(toPosition3D)) {
                    distances.put(new Pair(position3D, toPosition3D), position3D.getDistance(toPosition3D));
                }
            }
        }



        return 0L;
    }

    public static long task2(List<String> lines) {
        return 0L;
    }

}
