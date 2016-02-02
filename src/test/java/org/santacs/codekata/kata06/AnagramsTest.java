package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.Test;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();
    private final ByteArrayOutputStream oStream = new ByteArrayOutputStream();
    private final PrintStream out = new PrintStream(oStream);

    @Test
    public void shouldPrintAnagramsToSameLine() {
        anagrams.process(Stream.of("ab", "ba", "ac", "ca"));
        anagrams.printTo(out);
        assertThat(oStream.toString(), equalTo("ab ba\nac ca\n"));
    }

    @Test
    public void shouldIgnoreWordWithNoAnagram() {
        anagrams.process(Stream.of("ab", "ba", "ac"));
        anagrams.printTo(out);
        assertThat(oStream.toString(), equalTo("ab ba\n"));
    }

    @Test
    public void shouldPrintNothingWhenEmpty() {
        anagrams.printTo(out);
        assertThat(oStream.toString(), equalTo(""));
    }

    @Test
    public void shouldReturnAnagramCount() {
        anagrams.process(Stream.of("ab", "ba", "ac", "ca"));
        assertThat(anagrams.getCount(), equalTo(2));
    }

    @Test
    public void shouldReturnCountIsZeroWhenEmpty() {
        assertThat(anagrams.getCount(), equalTo(0));
    }
}
