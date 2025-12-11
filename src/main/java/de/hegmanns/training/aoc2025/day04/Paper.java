package de.hegmanns.training.aoc2025.day04;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Paper {
    private Position2D position2D;
    private TopologyForPapers placement;

    public Paper(int xPosition, int yPosition) {
        this(new Position2D(xPosition, yPosition), null);
    }

    public int getCountOfPaperInAdjacentPositions() {
        if (placement == null) {
            return 0;
        }

        int xPosition = position2D.xPosition();
        int yPosition = position2D.yPosition();

        int sum = 0;
        sum += placement.getCountOfPapers(xPosition, yPosition-1);
        sum += placement.getCountOfPapers(xPosition, yPosition+1);
        sum += placement.getCountOfPapers(xPosition+1, yPosition);
        sum += placement.getCountOfPapers(xPosition-1, yPosition);

        sum += placement.getCountOfPapers(xPosition-1, yPosition-1);
        sum += placement.getCountOfPapers(xPosition-1, yPosition+1);

        sum += placement.getCountOfPapers(xPosition+1, yPosition-1);
        sum += placement.getCountOfPapers(xPosition+1, yPosition+1);

        return sum;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "position=" + position2D +
                ", placement=" + placement +
                '}';
    }
}
