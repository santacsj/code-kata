package org.santacs.codekata.fizzbuzz;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void shouldPrintOneAs1() {
        assertGotFor(1, "1", aFizzBuzzStream());
    }

    @Test
    public void shouldPrintFizzWhenDivisableWithThree() {
        assertGotFor(3, "Fizz", aFizzBuzzStream());
    }

    @Test
    public void shouldPrintBuzzWhenDivisableWithFive() {
        assertGotFor(5, "Buzz", aFizzBuzzStream());
    }

    @Test
    public void shouldPrintFizzBuzzWhenDivisableBoth() {
        assertGotFor(15, "FizzBuzz", aFizzBuzzStream());
    }

    @Test
    public void shouldPrint20() {
        aFizzBuzzStream().limit(20).forEach(System.out::println);
    }

    private Stream<String> aFizzBuzzStream() {
        return Stream.generate(new FizzBuzz());
    }

    private void assertGotFor(int index, String expected, Stream<String> stream) {
        stream.skip(index - 1).limit(1).peek(s -> assertThat(s, equalTo(expected))).findAny();
    }

}
