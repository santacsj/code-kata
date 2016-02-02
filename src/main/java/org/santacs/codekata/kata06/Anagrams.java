package org.santacs.codekata.kata06;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {

    private List<List<String>> elements = Collections.emptyList();

    public void process(Stream<String> words) {
        elements = findValidAnagramsIn(everyPossibleAnagramsOf(words)).collect(Collectors.toList());
    }

    private Stream<List<String>> findValidAnagramsIn(Map<Word, List<String>> anagrams) {
        return anagrams.values().stream().filter(anagram -> anagram.size() > 1);
    }

    private Map<Word, List<String>> everyPossibleAnagramsOf(Stream<String> words) {
        return words.collect(Collectors.groupingBy(Word::new));
    }

    public void printTo(PrintStream os) {
        elements.forEach(anagram -> os.println(anagram.stream().collect(Collectors.joining(" "))));
    }

    public int getCount() {
        return elements.size();
    }

}
