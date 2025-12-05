package de.hegmanns.training.aoc2025.day05;

public class IngredientIdRangeBuilder {


    public static IngredientIdRange create(String stringDefinition) {
        String[] limits = stringDefinition.trim().split("-");
        if (limits.length != 2) {
            throw new IllegalArgumentException("Invalid string definition: " + stringDefinition);
        }
        return new IngredientIdRange(Long.parseLong(limits[0].trim()), Long.parseLong(limits[1].trim()));
    }
}
