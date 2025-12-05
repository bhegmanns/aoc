package de.hegmanns.training.aoc2025.day05;

import static org.assertj.core.api.Assertions.assertThat;
import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day05;
import org.junit.jupiter.api.Test;

public class Day05TaskTests {

    @Test
    void task01() {
        long countOfFreshIngredients = Day05.task1(AocFileLoader.loadLines(Day05.FILE_PATH));

        assertThat(countOfFreshIngredients).isEqualTo(652L);
    }

    @Test
    void task02() {
        long countOfFreshIds = Day05.task2(AocFileLoader.loadLines(Day05.FILE_PATH));
        assertThat(countOfFreshIds).isEqualTo(341753674214273L);
    }
}
