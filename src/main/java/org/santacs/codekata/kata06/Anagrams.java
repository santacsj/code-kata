package org.santacs.codekata.kata06;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {

    private List<AnagramSet> elements = Collections.emptyList();

    // FIXME: This should come from a collaborator, here I just want to see Word objects
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

    public void forEach(Consumer<AnagramSet> consumer) {
        elements.forEach(consumer);
    }

    public int getCount() {
        return elements.size();
    }

}
