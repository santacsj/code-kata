package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramCollectorTest {

    private final AnagramCollector collector = new AnagramCollector();
    private final AnagramCollectorTestAdapter test = new AnagramCollectorTestAdapter();

    @Test
    public void shouldMatchUpAnagrams() {

        test.withWords("ab", "ba", "ac", "ca");

        test.exercise(collector);

        assertThat(test.foundAnAnagram("ab ba"), is(true));
        assertThat(test.foundAnAnagram("ac ca"), is(true));
    }

    @Test
    public void shouldIgnoreWordsWithNoAnagrams() {

        test.withWords("ab");

        test.exercise(collector);

        assertThat(collector.getCount(), equalTo(0));
    }

    @Test
    public void shouldHaveZeroCountWhenEmpty() {
        assertThat(collector.getCount(), equalTo(0));
    }

}
