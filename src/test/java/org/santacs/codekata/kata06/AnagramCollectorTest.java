package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramCollectorTest {

    private final AnagramCollector collector = new AnagramCollector();
    private final AnagramCollectorTestAdapter adapter = new AnagramCollectorTestAdapter();

    @Test
    public void shouldMatchUpAnagrams() {

        adapter.useWords("ab", "ba", "ac", "ca");

        adapter.exercise(collector);

        assertThat(adapter.hasAnagram("ab ba"), is(true));
        assertThat(adapter.hasAnagram("ac ca"), is(true));
    }

    @Test
    public void shouldIgnoreWordsWithNoAnagrams() {

        adapter.useWords("ab");

        adapter.exercise(collector);

        assertThat(collector.getCount(), equalTo(0));
    }

    @Test
    public void shouldHaveZeroCountWhenEmpty() {
        assertThat(collector.getCount(), equalTo(0));
    }

}
