package de.hegmanns.training.aoc2025.day02;

import java.util.*;
import java.util.stream.Stream;

public class IdRange {
    private long minimumId;
    private long maximumId;

    public IdRange(long minimumId, long maximumId) {
        this.minimumId = minimumId;
        this.maximumId = maximumId;
    }


    public List<Long> resolveInvalidIdsForCompletelyTwiceSequence() {
        List<Long> listOfInvalidIds = new ArrayList<>();
        for (long i = minimumId; i <= maximumId; i++) {
            if (hasSameSequenceCompletelyTwice(i)) {
                listOfInvalidIds.add(i);
            }
        }
        return listOfInvalidIds;
    }

    public Stream<Long> streamOfInvalidIdsForCompletelyTwiceSequence() {
        return resolveInvalidIdsForCompletelyTwiceSequence().stream();
    }
    public Stream<Long> streamOfInvalidIdsForAtLeastTwiceSequences() {
        return resolveInvalidIdsForAtLeastTwiceSequences().stream();
    }
    public List<Long> resolveInvalidIdsForAtLeastTwiceSequences() {
        Set<Long> setOfInvalidIds = new HashSet<>();
        List<Long> listOfInvalidIds = new ArrayList<>();
        List<Long> doubleFoundedIds = new ArrayList<>();
        for (long i = minimumId; i <= maximumId; i++) {
            String stringOfDigits = Long.toString(i);

            for (int width = 1 ; width <= stringOfDigits.length()/2; width++) {
                if (stringOfDigits.length() % width != 0) {
                    continue;
                }
                String partialDigits =  stringOfDigits.substring(0, width);
                if (partialDigits.repeat(10).startsWith(stringOfDigits)) {
                    if (!setOfInvalidIds.add(i)) {
                        doubleFoundedIds.add(i);
                    }
                }

            }
        }

//        System.out.println("Doubletten found for " + minimumId + " - " + maximumId+ ": " +  doubleFoundedIds.stream().map((i) -> "" + i).collect(Collectors.joining(";")));
        listOfInvalidIds.addAll(setOfInvalidIds);
        return listOfInvalidIds;
    }

    private static boolean hasSameSequenceCompletelyTwice(long number) {
        String stringOfDigits = Long.toString(number);
        if (stringOfDigits.length() % 2 == 1) {
            return false;
        }

        String leftPartOfDigits = stringOfDigits.substring(0, stringOfDigits.length()/2);
        String rightPartOfDigits = stringOfDigits.substring(stringOfDigits.length()/2);
        return leftPartOfDigits.equals(rightPartOfDigits);
    }
}
