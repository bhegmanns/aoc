package de.hegmanns.training.aoc.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
public class Position3D {
    private int xPosition;
    private int yPosition;
    private int zPosition;

    public static Position3D readDefinitionStringIntoPosition(String definition) {
        String[] split = definition.trim().split(",");

        return new Position3D(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    public BigDecimal getDistance(Position3D position3D) {
        BigDecimal xDiff = new BigDecimal(xPosition - position3D.xPosition);
        BigDecimal yDiff = new BigDecimal(yPosition - position3D.yPosition);
        BigDecimal zDiff = new BigDecimal(zPosition - position3D.zPosition);

        BigDecimal squareSum = xDiff.pow(2).add(yDiff.pow(2)).add(zDiff.pow(2));
        return squareSum.sqrt(new MathContext(10, RoundingMode.HALF_DOWN));
    }
}
