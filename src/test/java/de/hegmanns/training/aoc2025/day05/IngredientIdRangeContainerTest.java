package de.hegmanns.training.aoc2025.day05;

import static org.assertj.core.api.Assertions.*;
import de.hegmanns.training.AocFileLoader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IngredientIdRangeContainerTest {

    IngredientIdRangeContainer ingredientIdRangeContainer = new IngredientIdRangeContainer();

    @Test
    void foo() {
        IngredientIdRange first = new IngredientIdRange(1, 3);
        IngredientIdRange second = new IngredientIdRange(1,2);

        List<IngredientIdRange> ingredientIdRanges = new ArrayList<>();
        ingredientIdRanges.add(first);

        assertThat(ingredientIdRanges.stream().filter(second::includes).findAny().isPresent()).isTrue();
        assertThat(ingredientIdRanges.stream().anyMatch(second::includes)).isTrue();
    }

    @Test
    void addIngredientIdRangeFirstTimeResultsInOneIncludedRange() {
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(1, 1));
        assertThat(ingredientIdRangeContainer.getIngredientIdRanges().size()).isEqualTo(1);
    }

    @Test
    void addCompleteIncludedRange() {
        IngredientIdRangeContainer ingredientIdRangeContainer = new IngredientIdRangeContainer();
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(1, 3));
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(1, 2));

        assertThat(ingredientIdRangeContainer.getIngredientIdRanges()).hasSize(1);
    }

    @Test
    void addOverlappedRanges() {
        IngredientIdRangeContainer ingredientIdRangeContainer = new IngredientIdRangeContainer();
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(1, 3));
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(3, 10));
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(-100, 2));

        assertThat(ingredientIdRangeContainer.getIngredientIdRanges()).hasSize(1);
        IngredientIdRange ingredientIdRange = ingredientIdRangeContainer.getIngredientIdRanges().get(0);
        assertThat(ingredientIdRange.getStartInclusive()).isEqualTo(-100);
        assertThat(ingredientIdRange.getEndInclusive()).isEqualTo(10);
    }

    @Test
    void overlappedRange() {
        IngredientIdRangeContainer ingredientIdRangeContainer = new IngredientIdRangeContainer();
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(1, 3));
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(3, 10));

        assertThat(ingredientIdRangeContainer.getIngredientIdRanges()).hasSize(1);
        IngredientIdRange ingredientIdRange = ingredientIdRangeContainer.getIngredientIdRanges().get(0);
        assertThat(ingredientIdRange.getStartInclusive()).isEqualTo(1);
        assertThat(ingredientIdRange.getEndInclusive()).isEqualTo(10);
    }

    @Test
    void directFollowingRange() {
        IngredientIdRangeContainer ingredientIdRangeContainer = new IngredientIdRangeContainer();
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(1, 3));
        ingredientIdRangeContainer.addIngredientIdRange(new IngredientIdRange(4, 10));

        assertThat(ingredientIdRangeContainer.getIngredientIdRanges()).hasSize(1);
        IngredientIdRange ingredientIdRange = ingredientIdRangeContainer.getIngredientIdRanges().get(0);
        assertThat(ingredientIdRange.getStartInclusive()).isEqualTo(1);
        assertThat(ingredientIdRange.getEndInclusive()).isEqualTo(10);
    }

    @Test
    void expectedRangesFromExample() {
        List<String> lines = AocFileLoader.loadLines(TestForExamples.EXAMPLE_FILE_PATH);
        IngredientIdRangeContainer ingredientIdRangeContainer = new IngredientIdRangeContainer();

        lines.stream().limit(lines.indexOf("")).forEach( l->ingredientIdRangeContainer.addIngredientIdRange(IngredientIdRangeBuilder.create(l)
        ));

        ingredientIdRangeContainer.harmonizeContainedIdRanges();

        assertThat(ingredientIdRangeContainer.getIngredientIdRanges()).hasSize(2);
        assertThat(ingredientIdRangeContainer.getCountFreshIds()).isEqualTo(14);
    }
}
