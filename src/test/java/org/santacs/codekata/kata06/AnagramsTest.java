package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class AnagramsTest {

    private final Anagrams anagrams = new Anagrams();

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
