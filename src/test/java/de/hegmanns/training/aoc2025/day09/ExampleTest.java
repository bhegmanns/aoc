package de.hegmanns.training.aoc2025.day09;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day09;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    public static final String EXAMPLE_FILE_PATH = "aoc2025/example09.txt";

    @Test
    void task1() {
        long maxArea = Day09.task1(AocFileLoader.loadLines(EXAMPLE_FILE_PATH));

        Assertions.assertThat(maxArea).isEqualTo(50L);
    }
}
