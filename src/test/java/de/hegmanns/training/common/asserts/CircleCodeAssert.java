package de.hegmanns.training.common.asserts;

import de.hegmanns.training.aoc2025.day01.CircleCode;
import org.assertj.core.api.AbstractAssert;

public class CircleCodeAssert extends AbstractAssert<CircleCodeAssert, CircleCode> {
    public CircleCodeAssert(CircleCode actual) {
        super(actual, CircleCodeAssert.class);
    }

    public static CircleCodeAssert assertThat(CircleCode actual) {
        return new CircleCodeAssert(actual);
    }

    public CircleCodeAssert hasCurrentNumber(int expected) {
        isNotNull();

        if (actual.getCurrentNumber() != expected) {
            failWithMessage("Expected number to be <%s> but was <%s>", expected, actual.getCurrentNumber());
        }

        return this;
    }

    public CircleCodeAssert hasHitZeroOnRotation(double expected) {
        isNotNull();

        if (actual.getHitZeroOnRotation() != expected) {
            failWithMessage("Expected number of hit zero on rotation <%s> but was <%s>", expected, actual.getHitZeroOnRotation());
        }
        return this;
    }

    public CircleCodeAssert hasHitZeros(double expected) {
        isNotNull();

        if (actual.getHitZero() != expected) {
            failWithMessage("Expected number if hit zerosto be <%s> but was <%s>", expected, actual.getHitZero());
        }

        return this;
    }
}
