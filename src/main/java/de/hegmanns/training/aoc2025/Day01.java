package de.hegmanns.training.aoc2025;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.day01.CircleCode;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Day01 {

    public final static String FILE_PATH = "aoc2025/task01.txt";
    static void main(String[] args) {

        List<String> lines = AocFileLoader.loadLines(FILE_PATH);

        int countZeros = task1(lines);
        System.out.println("Solution Day01, Task1: " + countZeros);

        int countZerosOnRotation = task2(lines);
        System.out.println("Solution Day01, Task2: " + countZerosOnRotation);

    }


    private static CircleCode createNewCircleCode() {
        CircleCode circleCode = new CircleCode(99);
        circleCode.setCurrentNumber(50);
        return circleCode;
    }

    public static int task1(List<String> lines){
        CircleCode circleCode = createNewCircleCode();

        Map<Character, Consumer<Integer>> consumerMap = circleCode.getConsumerMap();

        for (String line : lines) {
            int number = Integer.parseInt(line.substring(1));
            consumerMap.get(line.charAt(0)).accept(number);
//            if (line.startsWith("L")) {
//                circleCode.rotateLeft(number);
//            } else {
//                circleCode.rotateRight(number);
//            }
        }

        return circleCode.getHitZero();
    }

    public static int task2(List<String> lines){
        CircleCode circleCode = createNewCircleCode();

        for (String line : lines) {
            int number = Integer.parseInt(line.substring(1));

            if (line.startsWith("L")) {
                circleCode.rotateLeft(number);
            } else {
                circleCode.rotateRight(number);
            }
        }

        return circleCode.getHitZeroOnRotation();
    }
}
