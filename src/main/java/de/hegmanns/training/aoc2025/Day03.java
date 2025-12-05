package de.hegmanns.training.aoc2025;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.day03.BatteryBank;

import java.util.List;

public class Day03 {

    public final static String FILE_PATH = "aoc2025/task03.txt";
    static void main() {
        List<String> lines = AocFileLoader.loadLines(FILE_PATH);

        System.out.println("Solution Day03 part 1: " + task1(lines));
        System.out.println("Solution Day03 part 2: " + task2(lines));
    }

    public static long task1(List<String> lines) {

        long sum = 0L;
        for (String line : lines) {
            BatteryBank batteryBank = new BatteryBank(line);
            sum += batteryBank.getLargestPossibleVoltageByUsingTwoBatteries();
        }

        return sum;
    }

    public static long task2(List<String> lines) {

        long sum = 0L;
        for (String line : lines) {
            BatteryBank batteryBank = new BatteryBank(line);
            sum += batteryBank.getLargestPossibleVoltageByUsingTwelfeBatteries();
        }

        return sum;
    }
}
