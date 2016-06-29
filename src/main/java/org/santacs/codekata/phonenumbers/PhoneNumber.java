package org.santacs.codekata.phonenumbers;

public class PhoneNumber {

    public static PhoneNumber of(String s) {
        return new PhoneNumber(s, s.replace('-', ' ').replace(" ", ""));
    }

    private final String phoneNumber;
    private final String numbers;

    private PhoneNumber(String phoneNumber, String numbers) {
        this.phoneNumber = phoneNumber;
        this.numbers = numbers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private int length() {
        return numbers.length();
    }

    private boolean isPrefixOf(PhoneNumber that) {
        return that.numbers.startsWith(numbers);
    }

    public boolean isConsistentWith(PhoneNumber that) {
        return !(length() <= that.length() ? isPrefixOf(that) : that.isPrefixOf(this));
    }

    @Override
    public String toString() {
        return numbers;
    }

}
