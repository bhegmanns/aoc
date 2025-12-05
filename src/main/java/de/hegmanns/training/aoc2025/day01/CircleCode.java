package de.hegmanns.training.aoc2025.day01;

import java.util.Map;
import java.util.function.Consumer;

public class CircleCode {
    private final int minimalNumber = 0;
    private final int maximalNumber;
    private int currentNumber;
    private int countHitZero = 0;
    private int countHitZeroOnRotation = 0;

    public CircleCode(int maximalNumber) {
        this.maximalNumber = maximalNumber;
        this.currentNumber = 0;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    private int calculateClicks(int countClicks) {
        return countClicks % (maximalNumber - minimalNumber + 1);
    }

    private int calculateRotations(int countRotations) {
        return countRotations / (maximalNumber - minimalNumber + 1);
    }

    public Map<Character, Consumer<Integer>> getConsumerMap() {
        return Map.of('L', this::rotateLeft, 'R', this::rotateRight);
    }

    public void rotateLeft(int count) {
        int realRotateLeft = calculateClicks(count);
        boolean startAtZero = currentNumber==0;
        currentNumber -= realRotateLeft;
        if (currentNumber < minimalNumber) {
            currentNumber = maximalNumber+currentNumber+1;
            if (!startAtZero) {
                countHitZeroOnRotation++;
            }
        }
        recalculateHitZeroOnRotation(count, realRotateLeft);

        if (currentNumber == 0) {
            countHitZero++;
            countHitZeroOnRotation++;
        }
    }

    public void rotateRight(int count) {
        int realRotateRight = calculateClicks(count);
        boolean startAtZero = currentNumber==0;
        currentNumber += realRotateRight;
        if (currentNumber > maximalNumber) {
            currentNumber = currentNumber - (maximalNumber + 1);
            if (!startAtZero) {
                countHitZeroOnRotation++;
            }
        }
        recalculateHitZeroOnRotation(count, realRotateRight);
        if (currentNumber == 0) {
            countHitZero++;
        }
    }

    private void recalculateHitZeroOnRotation(int count, int realRotateRight) {
        if (realRotateRight != count) {
            countHitZeroOnRotation += calculateRotations(count);
        }
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int getHitZero() {
        return countHitZero;
    }
    public int getHitZeroOnRotation() {
        return countHitZeroOnRotation;
    }
}
