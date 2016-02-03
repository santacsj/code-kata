package org.santacs.codekata.kata06;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {

    private List<AnagramSet> elements = Collections.emptyList();

    public void process(Stream<String> words) {
        elements = findValidAnagramsIn(everyPossibleAnagramsOf(words));
    }

    private List<AnagramSet> findValidAnagramsIn(Stream<AnagramSet> anagrams) {
        return anagrams.filter(AnagramSet::isValid).collect(Collectors.toList());
    }

    private Stream<AnagramSet> everyPossibleAnagramsOf(Stream<String> words) {
        return words.map(Word::new).collect(Collectors.groupingBy(Function.identity())).values()
                .stream().map(AnagramSet::new);
    }

    // FIXME: Once Anagram class is ready, this can just collect the anagrams, another class can do reading, printing ->
    // Hexagon
    public void printTo(PrintStream os) {
        elements.forEach(anagram -> os.println(anagram.toString()));
    }

    public int getCount() {
        return elements.size();
    }

}
