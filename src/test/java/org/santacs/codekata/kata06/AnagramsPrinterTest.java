package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.Test;

public class AnagramsPrinterTest {

    private final Anagrams anagrams = new Anagrams();
    private final ByteArrayOutputStream oStream = new ByteArrayOutputStream();
    private final PrintStream out = new PrintStream(oStream);

    // FIXME: These cases should go to AnagramsTest

    @Test
    public void shouldPrintAnagramsToSameLine() {
        anagrams.process(Stream.of("ab", "ba", "ac", "ca"));
        new AnagramsPrinter(anagrams).printTo(out);
        assertThat(oStream.toString(), equalTo("ab ba\nac ca"));
    }

    @Test
    public void shouldIgnoreWordWithNoAnagram() {
        anagrams.process(Stream.of("ab", "ba", "ac"));
        new AnagramsPrinter(anagrams).printTo(out);
        assertThat(oStream.toString(), equalTo("ab ba"));
    }

    @Test
    public void shouldPrintNothingWhenEmpty() {
        new AnagramsPrinter(anagrams).printTo(out);
        assertThat(oStream.toString(), equalTo(""));
    }
}
