package de.hegmanns.training.aoc2025.day05;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IngredientIdRangeContainer {

    List<IngredientIdRange> ingredientIdRanges = new ArrayList<>();

    public void addIngredientIdRange(IngredientIdRange ingredientIdRange) {
        System.out.println("add range " + ingredientIdRange);
        if (!isRangeIncluded(ingredientIdRange)) {
            if (!integrateOverlappedRange(ingredientIdRange) && !integrateDirectFollowingRange(ingredientIdRange)) {
                ingredientIdRanges.add(ingredientIdRange);
            } else {
                System.out.println(" >>> is integrated into contented range");
            }
        }
    }

    private boolean isRangeIncluded(IngredientIdRange ingredientIdRange) {
        return ingredientIdRanges.stream().anyMatch(ingredientIdRange::includes);
    }

    private boolean isOverlapped(IngredientIdRange ingredientIdRange) {
        return ingredientIdRanges.stream().anyMatch(ingredientIdRange::overlaps);
    }

    private boolean integrateOverlappedRange(IngredientIdRange ingredientIdRange) {
        if (isOverlapped(ingredientIdRange)) {
            IngredientIdRange overlappedIdRange = getOverlappedIdRange(ingredientIdRange);
            overlappedIdRange.integrate(ingredientIdRange);
            return true;
        } else {
            return false;
        }
    }

    private boolean isDirectFollowingRange(IngredientIdRange ingredientIdRange) {
        return ingredientIdRanges.stream().anyMatch(ingredientIdRange::isDirectFollowing);
    }

    private boolean integrateDirectFollowingRange(IngredientIdRange ingredientIdRange) {
        if (isDirectFollowingRange(ingredientIdRange)) {
            IngredientIdRange directFollowingIdRange = getDirectFollowingIdRange(ingredientIdRange);
            directFollowingIdRange.integrate(ingredientIdRange);
            return true;
        } else {
            return false;
        }
    }

    private IngredientIdRange getDirectFollowingIdRange(IngredientIdRange ingredientIdRange) {
        return ingredientIdRanges.stream().filter(ingredientIdRange::isDirectFollowing).findFirst().get();
    }

    private IngredientIdRange getOverlappedIdRange(IngredientIdRange ingredientIdRange) {
        return ingredientIdRanges.stream().filter(ingredientIdRange::overlaps).findFirst().get();
    }

    public void harmonizeContainedIdRanges() {

        for (int i = 0 ; i < ingredientIdRanges.size(); i++) {
            IngredientIdRange ingredientIdRange = ingredientIdRanges.get(i);
            List<IngredientIdRange> candidatesForRemove = new ArrayList<>();
            for (int j = i+1 ; j < ingredientIdRanges.size(); j++) {
                if (ingredientIdRange.integrate(ingredientIdRanges.get(j))) {
                    candidatesForRemove.add(ingredientIdRanges.get(j));
                }
            }
            ingredientIdRanges.removeAll(candidatesForRemove);
        }
    }

    public long getCountFreshIds() {
        harmonizeContainedIdRanges();
        long countOfFreshIds = 0;
        for (IngredientIdRange ingredientIdRange : ingredientIdRanges) {
            countOfFreshIds+=ingredientIdRange.getCountContainedIds();
        }

        return countOfFreshIds;
    }
}
