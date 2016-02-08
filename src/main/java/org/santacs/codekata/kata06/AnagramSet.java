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

    private final Word word;
    private final List<Word> anagrams;

    public AnagramSet(List<Word> elements) {
        this.anagrams = elements;
        this.word = this.anagrams.get(0);
    }

    public boolean isValid() {
        return anagrams.size() > 1;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof AnagramSet))
            return false;
        AnagramSet that = (AnagramSet) obj;
        return word.anagramOf(that.word);
    }

    @Override
    public String toString() {
        return anagrams.stream().map(Word::toString).collect(Collectors.joining(" "));
    }

}