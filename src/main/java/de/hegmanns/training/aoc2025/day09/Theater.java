package de.hegmanns.training.aoc2025.day09;

import de.hegmanns.training.aoc2025.day04.Position2D;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.List;

public class Theater {

    List<Position2D> redTiles = new ArrayList<>();
    List<Position2D> greenTiles = new ArrayList<>(); // perhaps not needed

    public void addRedTile(Position2D tile){
        redTiles.add(tile);
    }

    public boolean isRectancleInsideRedAndGreenArea(Position2D from, Position2D to){
        int startIndex = gatherIndexOfPosition(from);
        int direction = -1;
        if (from.xPosition()<to.xPosition()){
            direction = 1;
        }
        for (int i = startIndex; i <= redTiles.size(); i+=direction){
            Position2D check =  redTiles.get(i);
            if (check.xPosition()<to.xPosition()){
                break;
            }
        }
        return true;
    }

    private int gatherIndexOfPosition(Position2D position2D) {
        for (int i = 0; i < redTiles.size(); i++) {
            if (position2D.equals(redTiles.get(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException("position not found");
    }


}
