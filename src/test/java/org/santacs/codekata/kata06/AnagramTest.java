package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {

    @Test
    public void shouldBeNotValidWhenHasLessThan2Words() {
        assertThat(Anagram.anAnagram("ab").isValid(), is(false));
    }

    @Test
    public void shouldEqualToOtherWithSameWords() {
        assertThat(Anagram.anAnagram("ab ba").equals(Anagram.anAnagram("ba ab")), is(true));
    }

    @Test
    public void shouldSupportToString() {
        assertThat(Anagram.anAnagram("ba ab").toString(), equalTo("ba ab"));
    }

}
