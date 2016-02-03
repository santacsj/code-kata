package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class WordTest {

    @Test
    public void shouldBeAnagramOfWordOfSameChars() {
        assertThat(new Word("ab").anagramOf(new Word("ba")), is(true));
    }

    @Test
    public void shouldEqualToItsAnagram() {
        assertThat(new Word("ab").equals(new Word("ba")), is(true));
    }

    @Test
    public void shouldHaveSameHashCodeAsItsAnagram() {
        assertThat(new Word("ab").hashCode() == new Word("ba").hashCode(), is(true));
    }

    @Test
    public void shouldReturnWordWhenToStringCalled() {
        assertThat(new Word("ab").toString(), equalTo("ab"));
    }

}
