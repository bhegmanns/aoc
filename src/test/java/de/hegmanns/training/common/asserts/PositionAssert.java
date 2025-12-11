package de.hegmanns.training.common.asserts;

import de.hegmanns.training.aoc.common.Position3D;
import org.assertj.core.api.AbstractAssert;

public class PositionAssert extends AbstractAssert<PositionAssert, Position3D> {

    protected PositionAssert(Position3D position3D) {
        super(position3D, PositionAssert.class);
    }

    public static PositionAssert assertThat(Position3D actual) {
        return new PositionAssert(actual);
    }

    public PositionAssert isSameAs(Position3D expected) {
        isNotNull();
        return this;
    }


}
