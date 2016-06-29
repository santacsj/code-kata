package org.santacs.codekata.fizzbuzz;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FizzBuzz implements Supplier<String> {

    private int number;

    @Override
    public String get() {
        nextNumber();
        return fizzBuzzedNumber();
    }

    private void nextNumber() {
        number += 1;
    }

    private String fizzBuzzedNumber() {
        String labels = concatLabelsIf(divisor -> number % divisor == 0);
        return !labels.isEmpty() ? labels : String.valueOf(number);
    }

    private String concatLabelsIf(Predicate<Integer> predicate) {
        StringBuilder sb = new StringBuilder();

        getDivisorLabels().forEach((divisor, label) -> {
            if (predicate.test(divisor))
                sb.append(label);
        });
        return sb.toString();
    }

    protected SortedMap<Integer, String> getDivisorLabels() {
        TreeMap<Integer, String> mappings = new TreeMap<>();
        mappings.put(3, "Fizz");
        mappings.put(5, "Buzz");
        return mappings;
    }

}
