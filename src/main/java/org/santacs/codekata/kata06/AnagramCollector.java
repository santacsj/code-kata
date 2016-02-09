package org.santacs.codekata.kata06;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AnagramCollector {

    private Set<Anagram> elements = Collections.emptySet();

    public void process(Supplier<Stream<Word>> supplier) {
        try (Stream<Word> words = supplier.get()) {
            process(words);
        }
    }

    private void process(Stream<Word> words) {
        elements = findValidAnagramsIn(everyPossibleAnagramOf(words));
    }

    private Set<Anagram> findValidAnagramsIn(Stream<Anagram> anagrams) {
        return anagrams.filter(Anagram::isValid).collect(toSet());
    }

    private Stream<Anagram> everyPossibleAnagramOf(Stream<Word> words) {
        return words.collect(groupingBy(identity())).values().stream().map(Anagram::new);
    }

    public boolean found(Anagram anAnagram) {
        return elements.contains(anAnagram);
    }

    public int getCount() {
        return elements.size();
    }

    public void forEach(Consumer<Anagram> consumer) {
        elements.forEach(consumer);
    }

}
