package de.hegmanns.training.aoc2025.day06;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day06;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06TaskTests {

    @Test
    void task01() {
        long totalResult = Day06.task1(AocFileLoader.loadLines(Day06.FILE_PATH));

        assertThat(totalResult).isEqualTo(6295830249262L);
    }

    @Test
    void task02() {
        long totalResult = Day06.task2(AocFileLoader.loadLines(Day06.FILE_PATH));
        assertThat(totalResult).isEqualTo(9194682052782L);
    }
}
