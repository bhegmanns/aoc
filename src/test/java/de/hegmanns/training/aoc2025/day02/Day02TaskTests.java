package de.hegmanns.training.aoc2025.day02;

import static org.assertj.core.api.Assertions.*;
import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.Day02;
import org.junit.jupiter.api.Test;

public class Day02TaskTests {

    @Test
    void task01() {
        long invalidIdsForTask01 = Day02.task1(AocFileLoader.loadFirstLine(Day02.FILE_PATH));

        assertThat(invalidIdsForTask01).isEqualTo(40055209690L);
    }

    @Test
    void task02() {
        long invalidIdsForTask02 = Day02.task2(AocFileLoader.loadFirstLine(Day02.FILE_PATH));
        assertThat(invalidIdsForTask02).isEqualTo(50857215650L);
    }
}
