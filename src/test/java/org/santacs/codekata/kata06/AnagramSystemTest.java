package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramSystemTest {

    @Test
    public void shouldFind20683SetsOfAnagrams() throws Exception {

        AnagramCollector collector = new AnagramCollector();

        collector.process(new FileWordStream(TestFiles.path()));

        assertThat(collector.getCount(), equalTo(20683));
    }

    @Test
    public void shouldPrintAllAnagramSets() throws Exception {
        AnagramCollector collector = new AnagramCollector();
        collector.process(new FileWordStream(TestFiles.path()));
        collector.forEach(new AnagramPrinter(System.out));
    }
}
