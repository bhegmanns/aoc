package de.hegmanns.training.aoc.common;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Position2D3DTest {

    @Test
    void parseZerosIntoPosition() {
        Position3D position3D = Position3D.readDefinitionStringIntoPosition("0,0,0");
        assertThat(position3D).isEqualTo(new Position3D(0, 0, 0));
    }

    @Test
    void parseZerosIntoPosition_162_817_812() {
        Position3D position3D = Position3D.readDefinitionStringIntoPosition("162,817,812");
        assertThat(position3D).isEqualTo(new Position3D(162, 817, 812));
    }
}
