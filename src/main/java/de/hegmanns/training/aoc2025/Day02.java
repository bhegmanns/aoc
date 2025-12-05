package de.hegmanns.training.aoc2025;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.day02.IdRange;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Day02 {

    public final static String FILE_PATH = "aoc2025/task02.txt";
    static void main() {
        String line = AocFileLoader.loadFirstLine(FILE_PATH);

        System.out.println("Solution Day02 part 1: " + task1(line));
        System.out.println("Solution Day02 part 2: " + task2(line));
    }


    static List<IdRange> mapIntoIdRanges(String line) {
        String[] rangeDefinitions = line.split(",");

        List<IdRange> idRanges = new ArrayList<>();

        for (String rangeDefinition : rangeDefinitions) {
            idRanges.add(mapIntoIdRange(rangeDefinition));
        }

        return idRanges;
    }

    static IdRange mapIntoIdRange(String rangeDefintion) {
        String[] rangeBoundaries = rangeDefintion.split("-");
        return new IdRange(Long.parseLong(rangeBoundaries[0]), Long.parseLong(rangeBoundaries[1]));
    }

    public static long task2(String line){

        return resolveTask(line, IdRange::resolveInvalidIdsForAtLeastTwiceSequences);
    }

    public static long task1(String line) {

        return resolveTask(line, IdRange::resolveInvalidIdsForCompletelyTwiceSequence);
    }

    private static long resolveTask(String line, Function<IdRange, List<Long>> idRangeFunction) {
        return mapIntoIdRanges(line).stream().map(idRangeFunction)
                .flatMap(List::stream)
                .mapToLong(Long::longValue)
                .sum();
    }

    public static List<String> loadLines(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
