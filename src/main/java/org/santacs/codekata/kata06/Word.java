package org.santacs.codekata.kata06;

import java.util.Arrays;

public class Word {

    private static String sortCharsOf(String s) {
        char[] data = s.toCharArray();
        Arrays.sort(data);
        return String.valueOf(data);
    }

    private final String word;
    private final String sortedChars;

    public Word(String word) {
        this.word = word;
        this.sortedChars = sortCharsOf(word);
    }

    public boolean anagramOf(Word that) {
        return sortedChars.equals(that.sortedChars);
    }

    @Override
    public int hashCode() {
        return sortedChars.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Word))
            return false;
        Word that = (Word) obj;
        return anagramOf(that);
    }

    @Override
    public String toString() {
        return word;
    }

}
