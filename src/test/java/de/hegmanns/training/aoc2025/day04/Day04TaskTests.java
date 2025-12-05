package de.hegmanns.training.aoc2025.day04;

import static org.assertj.core.api.Assertions.assertThat;
import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day04;
import org.junit.jupiter.api.Test;

public class Day04TaskTests {

    @Test
    void task01() {
        long countOfRemovePaperrolls = Day04.task1(AocFileLoader.loadLines(Day04.FILE_PATH));

        assertThat(countOfRemovePaperrolls).isEqualTo(1553L);
    }

    @Test
    void task02() {
        long countOfRemovePaperrolls = Day04.task2(AocFileLoader.loadLines(Day04.FILE_PATH));
        assertThat(countOfRemovePaperrolls).isEqualTo(8442L);
    }
}
