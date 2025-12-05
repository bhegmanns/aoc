package de.hegmanns.training.aoc2025;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.day05.IngredientIdRange;
import de.hegmanns.training.aoc2025.day05.IngredientIdRangeBuilder;
import de.hegmanns.training.aoc2025.day05.IngredientIdRangeContainer;

import java.util.ArrayList;
import java.util.List;

public class Day05 {

    public final static String FILE_PATH = "aoc2025/task05.txt";

    static void main() {
        List<String> lines = AocFileLoader.loadLines(FILE_PATH);

        System.out.println("Solution Day05 part 1: " + task1(lines));
        System.out.println("Solution Day05 part 2: " + task2(lines));
    }

    public static long task1(List<String> lines) {

        List<IngredientIdRange> ingredientIdRanges = new ArrayList<>();
        boolean ingredientIdRangeDefinitionPhase = true;
        long countOfFreshIngredients = 0L;
        for (String line : lines) {
            if (line.isEmpty()) {
                ingredientIdRangeDefinitionPhase = false;
                continue;
            }
            if (ingredientIdRangeDefinitionPhase) {
                ingredientIdRanges.add(IngredientIdRangeBuilder.create(line));
            } else {
                long ingredientId = Long.parseLong(line);
                if (ingredientIdRanges.stream().anyMatch(range -> range.includes(ingredientId))) {
                    countOfFreshIngredients++;
                }
            }
        }

        return countOfFreshIngredients;
    }

    public static long task2(List<String> lines) {
        IngredientIdRangeContainer ingredientIdRangeContainer = new IngredientIdRangeContainer();

        lines.stream().limit(lines.indexOf("")).forEach( l->ingredientIdRangeContainer.addIngredientIdRange(IngredientIdRangeBuilder.create(l)
        ));

        ingredientIdRangeContainer.harmonizeContainedIdRanges();

        return ingredientIdRangeContainer.getCountFreshIds();
    }
}
