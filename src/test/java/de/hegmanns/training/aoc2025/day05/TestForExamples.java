package de.hegmanns.training.aoc2025.day05;

import static org.assertj.core.api.Assertions.assertThat;
import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day05;
import org.junit.jupiter.api.Test;

public class TestForExamples {

    public static final String EXAMPLE_FILE_PATH = "aoc2025/example05.txt";

    @Test
    void exampleTask1() {
        long countOfFreshAvailableIngredientIds = Day05.task1(AocFileLoader.loadLines(EXAMPLE_FILE_PATH));
        assertThat(countOfFreshAvailableIngredientIds).isEqualTo(3L);
    }

    @Test
    void exampleTask2() {
        long countOfPossibleIngredients = Day05.task2(AocFileLoader.loadLines(EXAMPLE_FILE_PATH));
        assertThat(countOfPossibleIngredients).isEqualTo(14L);
    }
}
