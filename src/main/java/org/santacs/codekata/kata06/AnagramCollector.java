package org.santacs.codekata.kata06;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramCollector {

    private List<AnagramSet> elements = Collections.emptyList();

    public void process(Supplier<Stream<Word>> supplier) {
        try (Stream<Word> words = supplier.get()) {
            process(words);
        }
    }

    private void process(Stream<Word> words) {
        elements = findValidAnagramsIn(everyPossibleAnagramOf(words));
    }

    private List<AnagramSet> findValidAnagramsIn(Stream<AnagramSet> anagrams) {
        return anagrams.filter(AnagramSet::isValid).collect(Collectors.toList());
    }

    private Stream<AnagramSet> everyPossibleAnagramOf(Stream<Word> words) {
        return words.collect(Collectors.groupingBy(Function.identity())).values().stream()
                .map(AnagramSet::new);
    }

    public boolean found(AnagramSet anAnagram) {
        return elements.contains(anAnagram);
    }

    public int getCount() {
        return elements.size();
    }

}
