package org.santacs.codekata.phonenumbers;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhoneListTest {

    private PhoneList aPhoneList;

    @Before
    public void setUp() {
        aPhoneList = new PhoneList();
    }

    @Test
    public void shouldBeConsistentWhenEmpty() {
        assertThat(aPhoneList.isConsistent(), is(true));
    }

    @Test
    public void shouldBeConsistentWhenContainsOnePhoneNumber() {
        assertThat(aPhoneList.add(PhoneNumber.of("1")).isConsistent(), is(true));
    }

    @Test
    public void shouldBeConsistentWhenContainsPhoneNumberThatIsConsistentWithTheAdded() {
        aPhoneList = aPhoneList.add(PhoneNumber.of("12"));
        assertThat(aPhoneList.add(PhoneNumber.of("2")).isConsistent(), is(true));
    }

    @Test
    public void shouldNotBeConsistentWhenContainsPhoneNumberThatIsNotConsistentWithTheAdded() {
        aPhoneList = aPhoneList.add(PhoneNumber.of("12"));
        assertThat(aPhoneList.add(PhoneNumber.of("1")).isConsistent(), is(false));
    }

}
