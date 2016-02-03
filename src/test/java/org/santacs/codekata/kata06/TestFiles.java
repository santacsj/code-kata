package org.santacs.codekata.kata06;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class TestFiles {

    public static Path path() {
        return Paths.get("src/test/resources/anagrams.txt");
    }

    private TestFiles() {

    }
}
