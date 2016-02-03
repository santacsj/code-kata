package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

public class AnagramPrinterTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final PrintStream out = new PrintStream(outStream);
    private final AnagramPrinter printer = new AnagramPrinter(out);

    @Test
    public void shouldPrintAnagrams() {

        printer.accept(new AnagramSet(Arrays.asList(new Word("ab"), new Word("ba"))));
        printer.accept(new AnagramSet(Arrays.asList(new Word("ac"), new Word("ca"))));

        assertThat(outStream.toString(), equalTo("ab ba\nac ca\n"));
    }

}
