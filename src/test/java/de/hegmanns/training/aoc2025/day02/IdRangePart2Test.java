package de.hegmanns.training.aoc2025.day02;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IdRangePart2Test {

    @Test
    void range_11_to_22() {
        IdRange idRange = new IdRange(11, 22);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();

        assertThat(invalidIds).contains(11L, 22L);
    }

    @Test
    void range_95_to_115() {
        IdRange idRange = new IdRange(95, 115);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();

        assertThat(invalidIds).contains(99L, 111L);
    }

    @Test
    void range_998_to_1012() {
        IdRange idRange = new IdRange(998, 1012);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).contains(999L, 1010L);
    }

    @Test
    void range_1188511880_1188511890() {
        IdRange idRange = new IdRange(1188511880, 1188511890);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).contains(1188511885L);
    }

    @Test
    void range_222220_222224() {
        IdRange idRange = new IdRange(222222, 222224);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).contains(222222L);
    }

    @Test
    void range_1698522_1698528() {
        IdRange idRange = new IdRange(1698522, 1698528);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).isEmpty();
    }

    @Test
    void range_446443_446449() {
        IdRange idRange = new IdRange(446443, 446449);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).contains(446446L);
    }

    @Test
    void range_38593856_38593862() {
        IdRange idRange = new IdRange(38593856, 38593862);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).contains(38593859L);
    }

    @Test
    void range_565653_565659() {
        IdRange idRange = new IdRange(565653, 565659);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).contains(565656L);
    }

    @Test
    void range_824824821_824824827() {
        IdRange idRange = new IdRange(824824821, 824824827);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).contains(824824824L);
    }

    @Test
    void range_2121212118_2121212124() {
        IdRange idRange = new IdRange(2121212118, 2121212124);
        List<Long> invalidIds = idRange.resolveInvalidIdsForAtLeastTwiceSequences();
        assertThat(invalidIds).contains(2121212121L);
    }

}
