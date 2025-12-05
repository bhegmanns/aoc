package de.hegmanns.training.aoc2025.day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IngredientRangeBuilderTest {

    @Test
    void noDelimiterThrowException() {
        String stringDefinitionWithoutDelimter = "4334830511";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {IngredientIdRangeBuilder.create(stringDefinitionWithoutDelimter);});
    }

    @Test
    void emptyStringThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {IngredientIdRangeBuilder.create("");});
    }

    @Test
    void overloadedNumbersThrowsException() {
        String lowerLimit = Long.toString(Long.MIN_VALUE) + "0";
        String upperLimit = Long.toString(Long.MAX_VALUE) + "0";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IngredientIdRangeBuilder.create(lowerLimit + "-" + upperLimit);
        });
    }

    @Test
    void buildRangeOfGivenLongValues() {
        String stringDefinition = "433483051103449-435226969759467";

        IngredientIdRange ingredientIdRange = IngredientIdRangeBuilder.create(stringDefinition);
        org.assertj.core.api.Assertions.assertThat(ingredientIdRange.getStartInclusive()).isEqualTo(433483051103449L);
        org.assertj.core.api.Assertions.assertThat(ingredientIdRange.getEndInclusive()).isEqualTo(435226969759467L);
    }
}
