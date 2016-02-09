package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.santacs.codekata.kata06.Anagram.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class AnagramSystemTest {

    private final Path testFilePath = Paths.get("src/test/resources/anagrams.txt");

    @Test
    public void shouldFind20683SetsOfAnagrams() throws Exception {

        AnagramCollector collector = new AnagramCollector();

        collector.process(theTestFile());

        assertThat(collector.getCount(), equalTo(20683));
    }

    @Test
    public void shouldIncludeAllTimeFavourites() throws Exception {

        AnagramCollector collector = new AnagramCollector();

        collector.process(theTestFile());

        assertThat(collector.found(anAnagram("crepitus cuprites pictures piecrust")), is(true));
        assertThat(collector.found(anAnagram("paste pates peats septa spate tapes tepas")),
                is(true));
        assertThat(collector.found(anAnagram("punctilio unpolitic")), is(true));
        assertThat(collector.found(anAnagram("sunders undress")), is(true));
    }

    @Test
    public void shouldPrintAllAnagrams() throws Exception {

        AnagramCollector collector = new AnagramCollector();

        collector.process(theTestFile());

        collector.forEach(System.out::println);
    }

    private FileWordStream theTestFile() {
        return new FileWordStream(testFilePath);
    }

}
