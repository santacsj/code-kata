package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Stream;

import org.junit.Test;

public class AnagramsSystemTest {

    @Test
    public void shouldFind20683SetsOfAnagrams() throws Exception {
        Path file = Paths.get("src/test/resources/anagrams.txt");
        Stream<String> words = Files.lines(file, StandardCharsets.ISO_8859_1);

        Anagrams anagrams = new Anagrams();
        anagrams.process(words);

        assertThat(anagrams.getCount(), equalTo(20683));
    }
}
