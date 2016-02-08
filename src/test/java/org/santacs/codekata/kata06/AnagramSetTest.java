package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class AnagramSetTest {

    @Test
    public void shouldEqualToOtherWithSameWords() {
        assertThat(AnagramSet.anAnagramSet("ab ba").equals(AnagramSet.anAnagramSet("ba ab")), is(true));
    }

    @Test
    public void shouldCreateAnagramSetFromString() {
        assertThat(AnagramSet.anAnagramSet("ab ba")
                .equals(new AnagramSet(Arrays.asList(new Word("ab"), new Word("ba")))), is(true));
    }
}
