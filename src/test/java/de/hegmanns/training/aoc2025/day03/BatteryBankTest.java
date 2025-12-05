package de.hegmanns.training.aoc2025.day03;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BatteryBankTest {

    @Test
    void temporaryTestBySomeProblemsOfParameterizedTest() {
        BatteryBank batteryBank = new BatteryBank("234234234234278");
        assertThat(batteryBank.getLargestPossibleVoltageByUsingTwelfeBatteries()).isEqualTo(434234234278L);
    }

    @ParameterizedTest
    @CsvSource({"987654321111111, 98", "811111111111119, 89", "234234234234278, 78", "818181911112111, 92"})
    void givenExamplesForUsingTwoBatteries(String batteryBankDefinition, int expectedJoltage) {
        BatteryBank batteryBank = new BatteryBank(batteryBankDefinition);
        assertThat(batteryBank.getLargestPossibleVoltageByUsingTwoBatteries()).isEqualTo(expectedJoltage);
    }

    @ParameterizedTest
    @CsvSource({"987654321111111, 987654321111", "811111111111119, 811111111119", "234234234234278, 434234234278", "818181911112111, 888911112111"})
    void givenExamplesForUsingTwelveBatteries(String batteryBankDefinition, long expectedJoltage) {
        BatteryBank batteryBank = new BatteryBank(batteryBankDefinition);
        assertThat(batteryBank.getLargestPossibleVoltageByUsingTwelfeBatteries()).isEqualTo(expectedJoltage);
    }
}
