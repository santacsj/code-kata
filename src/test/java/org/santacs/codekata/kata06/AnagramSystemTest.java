package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramSystemTest {

    @Test
    public void shouldFind20683SetsOfAnagrams() throws Exception {

        AnagramCollector collector = new AnagramCollector();

        collector.process(new WordStreamSupplier(TestFiles.path()));

        assertThat(collector.getCount(), equalTo(20683));
    }
}
