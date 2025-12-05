package de.hegmanns.training;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AocFileLoader {

    public static List<String> loadLines(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String loadFirstLine(String path) {
        return loadLines(path).getFirst();
    }
}
