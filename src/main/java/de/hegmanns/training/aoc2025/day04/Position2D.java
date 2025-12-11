package de.hegmanns.training.aoc2025.day04;

public record Position2D(int xPosition, int yPosition)  {

    public boolean isLeftUpperTo(Position2D position){
        return this.xPosition<=position.xPosition && this.yPosition<=position.yPosition;
    }
}
