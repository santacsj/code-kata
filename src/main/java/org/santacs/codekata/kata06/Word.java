package org.santacs.codekata.kata06;

import java.util.Arrays;

public class Word {

    private final char[] chars;
    private final int hashCode;

    public Word(String word) {
        this.chars = word.toCharArray();
        Arrays.sort(this.chars);
        this.hashCode = Arrays.hashCode(this.chars);
    }

    public boolean anagramOf(Word that) {
        return Arrays.equals(chars, that.chars);
    }

    @Override
    public int hashCode() {
        return hashCode;
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
