package org.santacs.codekata.kata06;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramSet {

    private final Collection<Word> elements;

    public AnagramSet(Collection<Word> elements) {
        this.elements = Collections.unmodifiableList(new ArrayList<>(elements));
    }

    public boolean isValid() {
        return elements.size() > 1;
    }

    @Override
    public String toString() {
        return elements.stream().map(Word::toString).collect(Collectors.joining(" "));
    }

}