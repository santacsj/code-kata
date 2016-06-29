package org.santacs.codekata.phonenumbers;

import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneList {

    private final List<PhoneNumber> phoneNumbers;
    private boolean consistent;

    public PhoneList() {
        phoneNumbers = new LinkedList<>();
        consistent = true;
    }

    public boolean isConsistent() {
        return consistent;
    }

    public PhoneList add(PhoneNumber phoneNumber) {
        if (consistent)
            consistent = isConsistentWith(phoneNumber);
        phoneNumbers.add(phoneNumber);
        return this;
    }

    private boolean isConsistentWith(PhoneNumber otherPhoneNumber) {
        return phoneNumbers.stream()
                .map(phoneNumber -> phoneNumber.isConsistentWith(otherPhoneNumber))
                .filter(Boolean.FALSE::equals).findAny().orElse(true);
    }

    public static void main(String[] args) throws Exception {
        final Path testFilePath = Paths.get("src/test/resources/phone_data.txt");

        List<PhoneNumber> phoneNumbers = Files.lines(testFilePath).skip(1)
                .map(ln -> ln.substring(ln.indexOf(',') + 1)).map(PhoneNumber::of)
                .collect(Collectors.toList());

        PhoneList phoneList = new PhoneList();

        for (PhoneNumber e : phoneNumbers) {
            phoneList.add(e);
            if (!phoneList.isConsistent()) {
                System.out.println("This list is not consistent with " + e.getPhoneNumber());
                break;
            }
        }
    }

}
