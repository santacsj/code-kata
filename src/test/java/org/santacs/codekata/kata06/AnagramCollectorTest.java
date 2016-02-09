package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.santacs.codekata.kata06.Anagram.*;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class AnagramCollectorTest implements Supplier<Stream<Word>> {

    private final List<String> words = new LinkedList<>();
    private final AnagramCollector collector = new AnagramCollector();

    @Test
    public void shouldMatchUpAnagrams() {

        useWords("ab", "ba", "ac", "ca");

        collector.process(this);

        assertThat(collector.found(anAnagram("ab ba")), is(true));
        assertThat(collector.found(anAnagram("ac ca")), is(true));
    }

    @Test
    public void shouldIgnoreWordsWithNoAnagrams() {

        useWords("ab");

        collector.process(this);

        assertThat(collector.getCount(), equalTo(0));
    }

    @Test
    public void shouldHaveZeroCountWhenEmpty() {
        assertThat(collector.getCount(), equalTo(0));
    }

    private void useWords(String... elements) {
        words.addAll(Arrays.asList(elements));
    }

    @Override
    public Stream<Word> get() {
        return words.stream().map(Word::new);
    }

}
