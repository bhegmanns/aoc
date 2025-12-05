package de.hegmanns.training.aoc2025.day05;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IngredientIdRangeTest {

    @Test
    void equalIdRangesContainsEachOther() {
        IngredientIdRange ingredientIdRange1 = new IngredientIdRange(1, 1);
        IngredientIdRange ingredientIdRange2 = new IngredientIdRange(1, 1);

        assertThat(ingredientIdRange1.includes(ingredientIdRange2)).withFailMessage("yould be true").isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,1", "1,100", "99,100"})
    void includedRangeIn_1_100(long startInclusive, long endInclusive) {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);
        IngredientIdRange includedRange = new IngredientIdRange(startInclusive, endInclusive);
        assertThat(includedRange.includes(ingredientIdRange)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"101, 101", "101, 111", "-100, 0"})
    void notIncluededRangeIn_1_100(long startInclusive, long endInclusive) {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);
        IngredientIdRange includedRange = new IngredientIdRange(startInclusive, endInclusive);
        assertThat(includedRange.includes(ingredientIdRange)).isFalse();
    }

    @Test
    void overlapsRightBoundary() {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);
        assertThat(ingredientIdRange.overlaps(new IngredientIdRange(100, 200))).isTrue();
    }

    @Test
    void overlapsLeftBoundary() {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);
        assertThat(ingredientIdRange.overlaps(new IngredientIdRange(-100, 1))).isTrue();
    }

    @Test
    void integrateOverlappedRightRanges() {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);
        ingredientIdRange.integrate(new IngredientIdRange(100, 200));

        assertThat(ingredientIdRange.getStartInclusive()).isEqualTo(1);
        assertThat(ingredientIdRange.getEndInclusive()).isEqualTo(200);
    }

    @Test
    void integrateOverlappedLeftRanges() {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);
        ingredientIdRange.integrate(new IngredientIdRange(-50, 1));

        assertThat(ingredientIdRange.getStartInclusive()).isEqualTo(-50);
        assertThat(ingredientIdRange.getEndInclusive()).isEqualTo(100);
    }

    @Test
    void integrateDirectFollowingRangeRightSide() {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);
        ingredientIdRange.integrate(new IngredientIdRange(101, 200));

        assertThat(ingredientIdRange.getStartInclusive()).isEqualTo(1);
        assertThat(ingredientIdRange.getEndInclusive()).isEqualTo(200);
    }

    @Test
    void integrateDirectFollowingRangeLeftSide() {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);
        ingredientIdRange.integrate(new IngredientIdRange(-500, 0));

        assertThat(ingredientIdRange.getStartInclusive()).isEqualTo(-500);
        assertThat(ingredientIdRange.getEndInclusive()).isEqualTo(100);
    }

    @Test
    void directFollowingRightSide() {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);

        assertThat(ingredientIdRange.isDirectFollowing(new IngredientIdRange(101, 200))).isTrue();
    }

    @Test
    void directFollowingLeftSide() {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);

        assertThat(ingredientIdRange.isDirectFollowing(new IngredientIdRange(-100,0))).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"100,101", "102, 103", "-200, -1", "-200, 1"})
    void notDirectFollowingTo_1_100(long startInclusive, long endInclusive) {
        IngredientIdRange ingredientIdRange = new IngredientIdRange(1, 100);

        assertThat(ingredientIdRange.isDirectFollowing(new IngredientIdRange(startInclusive,endInclusive))).isFalse();
    }


}
