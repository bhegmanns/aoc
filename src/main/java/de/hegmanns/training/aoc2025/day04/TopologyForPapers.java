package de.hegmanns.training.aoc2025.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologyForPapers {
    private List<Paper> papers;
    private Map<Position2D, Paper> positionByPaer;

    public TopologyForPapers() {
        papers = new ArrayList<>();
        positionByPaer = new HashMap<>();
    }

    public void addPaper(Paper paper) {
        papers.add(paper);
        positionByPaer.put(paper.getPosition2D(), paper);
        paper.setPlacement(this);
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public int getCountOfPapers(Position2D position2D) {
        return positionByPaer.containsKey(position2D) ? 1 : 0;
    }

    public int getCountOfPapers(int xPosition, int yPosition) {
        return getCountOfPapers(new Position2D(xPosition, yPosition));
    }

    public void remove(List<Paper> papers) {
        this.papers.removeAll(papers);
        List<Position2D> list = papers.stream().map(Paper::getPosition2D).toList();
        list.forEach(this.positionByPaer.keySet()::remove);
    }
}
