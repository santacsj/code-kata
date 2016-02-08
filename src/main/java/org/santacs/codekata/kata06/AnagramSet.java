package org.santacs.codekata.kata06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramSet {

    public static AnagramSet anAnagramSet(String s) {
        String[] tokens = s.split(" ");
        List<Word> elements = Arrays.stream(tokens).map(Word::new).collect(Collectors.toList());
        return new AnagramSet(elements);
    }

    private final List<Word> elements;

    public AnagramSet(List<Word> elements) {
        this.elements = elements;
    }

    public boolean isValid() {
        return elements.size() > 1;
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof AnagramSet))
            return false;
        AnagramSet that = (AnagramSet) obj;
        return elements.equals(that.elements);
    }

    @Override
    public String toString() {
        return elements.stream().map(Word::toString).collect(Collectors.joining(" "));
    }

}