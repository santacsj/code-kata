package org.santacs.codekata.kata06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class WordStreamSupplier implements Supplier<Stream<Word>> {

    private final Path file;

    public WordStreamSupplier(Path file) {
        this.file = file;
    }

    @Override
    public Stream<Word> get() {
        try {
            return Files.lines(file, StandardCharsets.ISO_8859_1).map(Word::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
