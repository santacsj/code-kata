package org.santacs.codekata.kata06;

import java.util.Arrays;

public class Word {

    private static String sortCharsOf(String s) {
        char[] data = s.toCharArray();
        Arrays.sort(data);
        return String.valueOf(data);
    }

    private final String wordSortedByChars;

    public Word(String word) {
        wordSortedByChars = sortCharsOf(word);
    }

    public boolean anagramOf(Word that) {
        return wordSortedByChars.equals(that.wordSortedByChars);
    }

    @Override
    public int hashCode() {
        return wordSortedByChars.hashCode();
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

}
