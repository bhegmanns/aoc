package de.hegmanns.training.aoc2025.day05;

import lombok.Data;

import java.util.stream.LongStream;

@Data
public class IngredientIdRange {
    private long startInclusive;
    private long endInclusive;
    private LongStream range;

    public IngredientIdRange(long startInclusive, long endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        range = LongStream.rangeClosed(startInclusive, endInclusive);
    }


    public boolean includes(long ingredientId) {
        return startInclusive<=ingredientId && ingredientId<=endInclusive;
    }

    public boolean includes(IngredientIdRange ingredientIdRange) {
        return startInclusive>=ingredientIdRange.startInclusive &&  endInclusive<=ingredientIdRange.endInclusive;
    }

    public boolean overlaps(IngredientIdRange ingredientIdRange) {
        return (this.endInclusive>=ingredientIdRange.startInclusive && this.endInclusive<=ingredientIdRange.endInclusive)
                ||
                (this.startInclusive<=ingredientIdRange.endInclusive && this.startInclusive>=ingredientIdRange.startInclusive);
    }

    public boolean integrate(IngredientIdRange ingredientIdRange) {
        if (overlaps(ingredientIdRange) || isDirectFollowing(ingredientIdRange)) {
            this.startInclusive = Math.min(this.startInclusive, ingredientIdRange.startInclusive);
            this.endInclusive = Math.max(this.endInclusive, ingredientIdRange.endInclusive);
            return true;
        } else {
            return false;
        }
    }

    public boolean isDirectFollowing(IngredientIdRange ingredientIdRange) {
        return this.endInclusive==ingredientIdRange.startInclusive-1 || this.startInclusive==ingredientIdRange.endInclusive+1;
    }

    public Long getCountContainedIds() {
        return this.endInclusive - this.startInclusive + 1;
    }
}
