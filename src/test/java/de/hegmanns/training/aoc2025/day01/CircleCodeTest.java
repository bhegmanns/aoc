package de.hegmanns.training.aoc2025.day01;

import static org.assertj.core.api.Assertions.*;
import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day01;
import de.hegmanns.training.common.asserts.CircleCodeAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CircleCodeTest {
    private static final List<String> lines = AocFileLoader.loadLines(Day01.FILE_PATH);
    @Test
    public void task1() {
        assertThat(Day01.task1(lines)).isEqualTo(989);
    }

    @Test
    public void task2() {
        assertThat(Day01.task2(lines)).isEqualTo(5941);
    }


    @Test
    public void rotateLeftRight() {
        CircleCode circleCode = new CircleCode(1);

        circleCode.rotateLeft(1);
        circleCode.rotateRight(1);

        CircleCodeAssert.assertThat(circleCode).hasCurrentNumber(0);
    }

    @Test
    public void rotate3TimesLeft() {
        CircleCode circleCode = new CircleCode(1);
        circleCode.rotateLeft(3);

        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(1)
                .hasHitZeroOnRotation(1);
    }
    @Test
    public void rotate3TimesRight() {
        CircleCode circleCode = new CircleCode(1);
        circleCode.rotateRight(3);

        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(1);
    }

    @Test
    public void rotate3TimeToRightResultInNullZeroHits() {
        CircleCode circleCode = new CircleCode(99);
        circleCode.rotateRight(3);

        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(3)
                .hasHitZeroOnRotation(0);
    }

    @Test
    public void rotate3TimeToLeftResultInNullZeroHits() {
        CircleCode circleCode = new CircleCode(99);
        circleCode.rotateLeft(3);

        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(97)
                .hasHitZeroOnRotation(0);
    }

    @Test
    public void programmaticExample() {
        CircleCode circleCode = new CircleCode(99);
        circleCode.setCurrentNumber(50);

        circleCode.rotateLeft(68);
        CircleCodeAssert.assertThat(circleCode)
                .hasHitZeroOnRotation(1);

        circleCode.rotateLeft(30);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(52);

        circleCode.rotateRight(48);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(0)
                .hasHitZeroOnRotation(2);

        circleCode.rotateLeft(5);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(95)
                .hasHitZeroOnRotation(2);

        circleCode.rotateRight(60);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(55)
                .hasHitZeroOnRotation(3);

        circleCode.rotateLeft(55);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(0)
                .hasHitZeroOnRotation(4);

        circleCode.rotateLeft(1);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(99);

        circleCode.rotateLeft(99);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(0)
                .hasHitZeroOnRotation(5);

        circleCode.rotateRight(14);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(14);

        circleCode.rotateLeft(82);
        CircleCodeAssert.assertThat(circleCode)
                .hasCurrentNumber(32)
                .hasHitZeroOnRotation(6)
                .hasHitZeros(3);
    }
}
