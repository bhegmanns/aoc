package de.hegmanns.training.aoc.common;

import static org.assertj.core.api.Assertions.*;
import de.hegmanns.training.aoc2025.day04.Position2D;
import org.junit.jupiter.api.Test;

public class Position2DLeftUpperPositionTest {

    @Test
    void zeroPositionToOther() {
        Position2D zeroPosition = new Position2D(0,0);
        Position2D onePosition = new Position2D(1,1);

        assertThat(zeroPosition.isLeftUpperTo(onePosition)).isTrue();
    }

    @Test
    void otherToZeroPosition() {
        Position2D zeroPosition = new Position2D(0,0);
        Position2D onePosition = new Position2D(1,1);

        assertThat(onePosition.isLeftUpperTo(zeroPosition)).isFalse();
    }

    @Test
    void samePosition() {
        Position2D anyPosition = new Position2D(10, 20);
        Position2D samePosition = new Position2D(10, 20);

        assertThat(anyPosition.isLeftUpperTo(samePosition)).isTrue();
        assertThat(samePosition.isLeftUpperTo(anyPosition)).isTrue();
    }

    @Test
    void sameVerticalLineLowerPosition() {
        Position2D anyPosition = new Position2D(10, 20);
        Position2D lowerPosition = new Position2D(10, 50);
        assertThat(anyPosition.isLeftUpperTo(lowerPosition)).isTrue();
        assertThat(lowerPosition.isLeftUpperTo(anyPosition)).isFalse();
    }

    @Test
    void sameVerticalLineHigherPosition() {
        Position2D anyPosition = new Position2D(10, 20);
        Position2D higherPosition = new Position2D(10, 6);
        assertThat(anyPosition.isLeftUpperTo(higherPosition)).isFalse();
        assertThat(higherPosition.isLeftUpperTo(anyPosition)).isTrue();
    }

    @Test
    void sameHorizontalLineMorLeftPosition() {
        Position2D anyPosition = new Position2D(10, 20);
        Position2D moreLeftPosition = new Position2D(9, 20);

        assertThat(anyPosition.isLeftUpperTo(moreLeftPosition)).isFalse();
        assertThat(moreLeftPosition.isLeftUpperTo(anyPosition)).isTrue();
    }

    @Test
    void sameHorizontalLineMorRightPosition() {
        Position2D anyPosition = new Position2D(10, 20);
        Position2D moreRightPosition = new Position2D(11, 20);

        assertThat(anyPosition.isLeftUpperTo(moreRightPosition)).isTrue();
        assertThat(moreRightPosition.isLeftUpperTo(anyPosition)).isFalse();
    }
}
