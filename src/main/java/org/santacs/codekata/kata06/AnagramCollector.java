package org.santacs.codekata.kata06;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AnagramCollector {

    private Set<AnagramSet> elements = Collections.emptySet();

    public void process(Supplier<Stream<Word>> supplier) {
        try (Stream<Word> words = supplier.get()) {
            process(words);
        }
    }

    private void process(Stream<Word> words) {
        elements = findValidAnagramsIn(everyPossibleAnagramOf(words));
    }

    private Set<AnagramSet> findValidAnagramsIn(Stream<AnagramSet> anagrams) {
        return anagrams.filter(AnagramSet::isValid).collect(toSet());
    }

    private Stream<AnagramSet> everyPossibleAnagramOf(Stream<Word> words) {
        return words.collect(groupingBy(identity())).values().stream().map(AnagramSet::new);
    }

    public boolean found(AnagramSet anAnagram) {
        return elements.contains(anAnagram);
    }

    public int getCount() {
        return elements.size();
    }

    public void forEachAnagramSet(Consumer<AnagramSet> consumer) {
        elements.forEach(consumer);
    }

}
