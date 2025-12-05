package de.hegmanns.training.aoc2025;

import de.hegmanns.training.AocFileLoader;
import de.hegmanns.training.aoc2025.day04.Paper;
import de.hegmanns.training.aoc2025.day04.TopologyForPapers;

import java.util.ArrayList;
import java.util.List;

public class Day04 {

    public final static String FILE_PATH = "aoc2025/task04.txt";
    static void main() {
        List<String> lines = AocFileLoader.loadLines(FILE_PATH);

        System.out.println("Solution Day03 part 1: " + task1(lines));
        System.out.println("Solution Day03 part 2: " + task2(lines));
    }

    public static long task1(List<String> lines) {

        TopologyForPapers topology = parseTopology(lines);

        return topology.getPapers().stream().map(Paper::getCountOfPaperInAdjacentPositions)
                .filter(i -> i <4).count();
    }

    private static TopologyForPapers parseTopology(List<String> lines) {
        TopologyForPapers topology = new TopologyForPapers();
        int y = 0;
        for (String line : lines) {
            for (int x = 0 ; x < line.length(); x++) {
                char c = line.charAt(x);
                if (c == '@') {
                    Paper paper = new Paper(x, y);
                    topology.addPaper(paper);
                }
            }
            y++;
        }

        return topology;
    }
    public static long task2(List<String> lines) {
        TopologyForPapers topology = parseTopology(lines);

        long count = 0L;
        long countOfIteration = 0L;

        do {
            List<Paper> papersInsideTopology = topology.getPapers();
            List<Paper> removablePapers = new ArrayList<>();
            countOfIteration=0L;
            for (Paper paper : papersInsideTopology) {
                if (paper.getCountOfPaperInAdjacentPositions() < 4) {
                    removablePapers.add(paper);
                    countOfIteration++;
                }
            }
            topology.remove(removablePapers);
            count += countOfIteration;

//            System.out.println("Iteration. Entfernte Papierrollen: " + countOfIteration);
        }while(countOfIteration>0);
        return count;
    }
}
