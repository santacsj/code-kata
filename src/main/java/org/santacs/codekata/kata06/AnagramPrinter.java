package org.santacs.codekata.kata06;

import java.io.PrintStream;
import java.util.function.Consumer;

public class AnagramPrinter implements Consumer<AnagramSet> {

    private final PrintStream out;

    public AnagramPrinter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void accept(AnagramSet anagramSet) {
        out.println(anagramSet.toString());
    }

}