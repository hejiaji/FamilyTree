package main.enums;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public static Gender fromValue(String value) {
        return Arrays.stream(values())
                .filter(gender -> gender.value().equals(value))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("no element as %s", value)));
    }


    public String value() {
        return value;
    }
}
