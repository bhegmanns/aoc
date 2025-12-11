package de.hegmanns.training.aoc2025.day09;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day06;
import de.hegmanns.training.aoc2025.Day09;
import org.junit.jupiter.api.Test;

public class Day09TaskTest {

    @Test
    void task01() {
        long maxArea = Day09.task1(AocFileLoader.loadLines(Day09.FILE_PATH));

        assertThat(maxArea).isEqualTo(4746238001L);
    }

    @Test
    void task02() {
        long totalResult = Day09.task2(AocFileLoader.loadLines(Day09.FILE_PATH));

    }
}
