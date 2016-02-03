package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class AnagramCollectorTest implements Supplier<Stream<Word>>, Consumer<AnagramSet> {

    private final AnagramCollector collector = new AnagramCollector();

    private final List<String> words = new LinkedList<>();
    private final List<String> anagrams = new LinkedList<>();

    @Test
    public void shouldMatchUpAnagrams() {

        words.addAll(Arrays.asList("ab", "ba", "ac", "ca"));

        collector.process(this);
        collector.forEach(this);

        assertThat(anagrams.contains("ab ba"), is(true));
        assertThat(anagrams.contains("ac ca"), is(true));
    }

    @Test
    public void shouldIgnoreWordsWithNoAnagrams() {

        words.add("ab");

        collector.process(this);
        collector.forEach(this);

        assertThat(collector.getCount(), equalTo(0));
    }

    @Test
    public void shouldHaveZeroCountWhenEmpty() {
        assertThat(collector.getCount(), equalTo(0));
    }

    @Override
    public Stream<Word> get() {
        return words.stream().map(Word::new);
    }

    @Override
    public void accept(AnagramSet t) {
        anagrams.add(t.toString());
    }

}
