package de.hegmanns.training.aoc2025.day03;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day02;
import de.hegmanns.training.aoc2025.Day03;
import org.junit.jupiter.api.Test;

public class Day03TaskTests {

    @Test
    void task01() {
        long invalidIdsForTask01 = Day03.task1(AocFileLoader.loadLines(Day03.FILE_PATH));

        assertThat(invalidIdsForTask01).isEqualTo(17324L);
    }

    @Test
    void task02() {
        long invalidIdsForTask02 = Day03.task2(AocFileLoader.loadLines(Day03.FILE_PATH));
        assertThat(invalidIdsForTask02).isEqualTo(171846613143331L);
    }
}
