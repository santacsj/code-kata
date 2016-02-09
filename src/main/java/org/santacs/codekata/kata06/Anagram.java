package org.santacs.codekata.kata06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    public static Anagram anAnagram(String s) {
        String[] tokens = s.split(" ");
        List<Word> elements = Arrays.stream(tokens).map(Word::new).collect(Collectors.toList());
        return new Anagram(elements);
    }

    private final List<Word> elements;

    public Anagram(List<Word> elements) {
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
        if (!(obj instanceof Anagram))
            return false;
        Anagram that = (Anagram) obj;
        return elements.equals(that.elements);
    }

    @Override
    public String toString() {
        return elements.stream().map(Word::toString).collect(Collectors.joining(" "));
    }

}