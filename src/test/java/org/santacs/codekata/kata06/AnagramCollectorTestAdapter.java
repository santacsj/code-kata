package org.santacs.codekata.kata06;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AnagramCollectorTestAdapter implements Supplier<Stream<Word>>, Consumer<AnagramSet> {

    private final List<String> words = new LinkedList<>();
    private final List<String> anagrams = new LinkedList<>();

    public void withWords(String... elements) {
        words.addAll(Arrays.asList(elements));
    }

    public boolean foundAnAnagram(String anagram) {
        return anagrams.contains(anagram);
    }

    public void exercise(AnagramCollector collector) {
        collector.process(this);
        collector.forEach(this);
    }

    @Override
    public Stream<Word> get() {
        return words.stream().map(Word::new);
    }

    @Override
    public void accept(AnagramSet t) {
        anagrams.add(t.toString());
    }
}
