package de.hegmanns.training.aoc2025;

import de.hegmanns.training.AocFileLoader;

import java.util.*;
import java.util.function.BiFunction;

public class Day06 {

    public final static String FILE_PATH = "aoc2025/task06.txt";

    static void main() {
        List<String> lines = AocFileLoader.loadLines(FILE_PATH);

        System.out.println("Solution Day05 part 1: " + task1(lines));
        System.out.println("Solution Day05 part 2: " + task2(lines));
    }

    public static long task1(List<String> lines) {

        List<Long> columResults = new ArrayList<>();
        List<List<Long>> columns = new ArrayList<>();
        boolean firstRow = true;

        for (String line : lines) {
            String[] elements = line.trim().split("\\s+");
            if (firstRow) {
                for (String element : elements) {
                    List<Long> row = new ArrayList<>();
                    row.add(Long.parseLong(element));
                    columns.add(row);
                }
                firstRow = false;
            } else {
                if (elements[0].equals("+") || elements[0].equals("*")) {
                    int row = 0;
                    for (String element : elements) {
                        List<Long> numbersInColumn = columns.get(row);
                        long result = 0L;
                        if (element.equals("+")) {
                            for (Long number : numbersInColumn) {
                                result += number;
                            }
                        } else {
                            result = 1L;
                            for (Long number : numbersInColumn) {
                                result *= number;
                            }
                        }
                        columResults.add(result);
                        row++;
                    }

                } else {
                    int row = 0;
                    for (String element : elements) {
                        columns.get(row).add(Long.parseLong(element));
                        row++;
                    }
                }
            }
            //System.out.println(Arrays.toString(elements));
        }
        return columResults.stream().reduce(0L, Long::sum);
    }

    public static long task2(List<String> lines) {
        int maxLength = lines.stream().map(String::length).max(Comparator.naturalOrder()).get();
        List<String> harmonizedLines = new ArrayList<>();
        for (String line : lines) {
            if (line.length() < maxLength) {
                line += " ".repeat(maxLength - line.length());
                harmonizedLines.add(line);
            } else {
                harmonizedLines.add(line);
            }
        }

        BiFunction<Long, Long, Long> operation = null;
        long totalSum = 0L;
        long partialResult = 0L;

        for (int i = 0 ; i < maxLength; i++) {
            String numberString = "";
            for (String line : harmonizedLines) {
                String characterStringAtPosition = line.substring(i, i + 1);
                if (!characterStringAtPosition.trim().isEmpty()) {
                    if (characterStringAtPosition.equals("+")) {
                        operation = Day06::operationPlus;
                        totalSum += partialResult;
                        System.out.println("PartialResult: " + partialResult);
                        partialResult = 0L;
                    }
                    if (characterStringAtPosition.equals("*")) {
                        operation = Day06::operationMultiplication;
                        totalSum += partialResult;
                        System.out.println("PartialResult: " + partialResult);
                        partialResult = 1L;
                    }
                    if (!characterStringAtPosition.equals("+") && !characterStringAtPosition.equals("*")) {
                        numberString += characterStringAtPosition;
                    }
                }
            }
            if (!numberString.trim().isEmpty()) {
                partialResult = operation.apply(partialResult, Long.parseLong(numberString));
            }
        }
        totalSum += partialResult;
        return totalSum;
    }


    public static long operationPlus(Long first, Long second) {
        return first + second;
    }

    public static long operationMultiplication(Long first, Long second) {
        return first * second;
    }
}
