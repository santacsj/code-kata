package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class FileWordStreamTest {

    @Test
    public void shouldReturnWordsFromFile() {
        Supplier<Stream<Word>> supplier = new FileWordStream(TestFiles.path());
        assertThat(supplier.get().count(), not(0));
    }
}
