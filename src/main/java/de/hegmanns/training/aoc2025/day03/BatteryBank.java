package de.hegmanns.training.aoc2025.day03;

import java.util.*;
import java.util.stream.Collectors;

public class BatteryBank {
    private int[] voltages;

    public BatteryBank(String stringDefinitionForBank) {
        voltages = new int[stringDefinitionForBank.length()];
        for (int i = 0; i < voltages.length; i++) {
            voltages[i] = Integer.parseInt(stringDefinitionForBank.substring(i, i + 1));
        }

        System.out.println("Voltages: " + Arrays.toString(voltages));
    }

    public long getLargestPossibleVoltageByUsingTwoBatteries() {

        List<Integer> elements = new ArrayList<>();
        for (int i = 0 ; i < voltages.length ; i++) {
            elements.add(voltages[i]);
        }
        Integer highestValue = elements.stream().limit(voltages.length-1).max(Comparator.naturalOrder()).get();
        int index = findFirstIndexOfVoltage(0, highestValue);

        Integer nextValue = elements.stream().skip(index+1).max(Comparator.naturalOrder()).get();

        return highestValue*10 + nextValue;
    }

    public long getLargestPossibleVoltageByUsingTwelfeBatteries() {
        return getLargestPossibleVoltageByUsingBatteries(12);

//        List<Integer> elements = new ArrayList<>();
//        for (int voltage : voltages) {
//            elements.add(voltage);
//        }
//
//        List<Integer> valuesForJoltage = new ArrayList<>();
//
//        int minimalIndex = -1;
//        int countOfSelectedBatteries = 12;
//        int currentFinalIndex = voltages.length-countOfSelectedBatteries+1;
//        for (int i = 1; i <= 12; i++) {
//            Integer valueForJoltage = elements.subList(minimalIndex + 1, currentFinalIndex).stream().max(Comparator.naturalOrder()).get();
//            minimalIndex = findFirstIndexOfVoltage(minimalIndex+1, valueForJoltage);
//            valuesForJoltage.add(valueForJoltage);
//            currentFinalIndex++;
//        }
//        String collect = valuesForJoltage.stream().map(i -> "" + i).collect(Collectors.joining());
//        return Long.parseLong(collect);
    }

    public long getLargestPossibleVoltageByUsingBatteries(int countOfBatteriesInOneBlock) {
        List<Integer> elements = new ArrayList<>();
        for (int voltage : voltages) {
            elements.add(voltage);
        }

        List<Integer> valuesForJoltage = new ArrayList<>();

        int minimalIndex = -1;
        int currentFinalIndex = voltages.length-countOfBatteriesInOneBlock+1;
        for (int i = 1; i <= 12; i++) {
            Integer valueForJoltage = elements.subList(minimalIndex + 1, currentFinalIndex).stream().max(Comparator.naturalOrder()).get();
            minimalIndex = findFirstIndexOfVoltage(minimalIndex+1, valueForJoltage);
            valuesForJoltage.add(valueForJoltage);
            currentFinalIndex++;
        }
        String collect = valuesForJoltage.stream().map(i -> "" + i).collect(Collectors.joining());
        return Long.parseLong(collect);
    }

    private int findFirstIndexOfVoltage(int start, int expectedVoltage) {
        for (int i = start ; i < voltages.length ; i++) {
            if (voltages[i] == expectedVoltage) {
                return i;
            }
        }
        throw new IllegalArgumentException("voltage not found");
    }
}
