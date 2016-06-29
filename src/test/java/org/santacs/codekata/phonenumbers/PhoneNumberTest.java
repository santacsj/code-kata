package org.santacs.codekata.phonenumbers;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneNumberTest {

    @Test
    public void shouldBeConsistentWithPhoneNumberOfSameLength() {
        assertThat(PhoneNumber.of("1").isConsistentWith(PhoneNumber.of("2")), is(true));
    }

    @Test
    public void shouldBeConsistentWithPhoneNumberThatDoesNotStartWithIt() {
        assertThat(PhoneNumber.of("1").isConsistentWith(PhoneNumber.of("23")), is(true));
        assertThat(PhoneNumber.of("23").isConsistentWith(PhoneNumber.of("1")), is(true));
    }

    @Test
    public void shouldNotBeConsistentWithPhoneNumberThatStartWithIt() {
        assertThat(PhoneNumber.of("1").isConsistentWith(PhoneNumber.of("12")), is(false));
        assertThat(PhoneNumber.of("12").isConsistentWith(PhoneNumber.of("1")), is(false));
    }

    @Test
    public void shouldIgnoreSeparators() {
        assertThat(PhoneNumber.of("1 2-3").toString(), equalTo(PhoneNumber.of("123").toString()));
    }

    @Test
    public void shouldReturnPhoneNumber() {
        assertThat(PhoneNumber.of("1 2-3").getPhoneNumber(), equalTo("1 2-3"));
    }
}
