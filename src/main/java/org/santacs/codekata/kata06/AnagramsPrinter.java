package org.santacs.codekata.kata06;

import java.io.PrintStream;
import java.util.function.Consumer;

public class AnagramsPrinter {

    private final Anagrams anagrams;

    public AnagramsPrinter(Anagrams anagrams) {
        this.anagrams = anagrams;
    }

    public void printTo(PrintStream os) {
        anagrams.forEach(new Consumer<AnagramSet>() {

            private final int lastButOneElement = anagrams.getCount() - 1;
            private int elementCount;

            @Override
            public void accept(AnagramSet t) {
                if (elementCount++ < lastButOneElement)
                    os.println(t.toString());
                else
                    os.print(t.toString());
            }
        });
    }

}