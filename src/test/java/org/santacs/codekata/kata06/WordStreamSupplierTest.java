package org.santacs.codekata.kata06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

public class WordStreamSupplierTest {

    @Test
    public void shouldReturnWordsFromFile() {
        Supplier<Stream<Word>> supplier = new WordStreamSupplier(TestFiles.path());
        assertThat(supplier.get().count(), not(0));
    }
}
