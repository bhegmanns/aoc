package de.hegmanns.training.aoc2025.day04;

import static org.assertj.core.api.Assertions.*;
import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day04;
import org.junit.jupiter.api.Test;

public class TestsForExamples {

    public final static String EXAMPLE_FILE_PATH = "aoc2025/example04.txt";

    @Test
    void exampleTask1() {
        long l = Day04.task1(AocFileLoader.loadLines(EXAMPLE_FILE_PATH));
        assertThat(l).isEqualTo(13L);
    }

    @Test
    void exampleTask2() {
        long l = Day04.task2(AocFileLoader.loadLines(EXAMPLE_FILE_PATH));
        assertThat(l).isEqualTo(43L);
    }
}
