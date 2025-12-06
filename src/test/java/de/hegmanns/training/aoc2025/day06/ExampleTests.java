package de.hegmanns.training.aoc2025.day06;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day06;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTests {

    public static final String EXAMPLE_FILE_PATH = "aoc2025/example06.txt";

    @Test
    void foo() {
        Day06.task1(AocFileLoader.loadLines(EXAMPLE_FILE_PATH));
    }

    @Test
    void task1() {
        long totalResult = Day06.task1(AocFileLoader.loadLines(EXAMPLE_FILE_PATH));

        Assertions.assertThat(totalResult).isEqualTo(4277556L);
    }

    @Test
    void task2() {
        long totalResult = Day06.task2(AocFileLoader.loadLines(EXAMPLE_FILE_PATH));


        Assertions.assertThat(totalResult).isEqualTo(3263827L);
    }
}
