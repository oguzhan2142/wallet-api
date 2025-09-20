package com.oguzhan.wallet.domain.user;

import com.oguzhan.wallet.domain.exceptions.InvalidNameException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Locale;


@Embeddable
public record Name(
        @Column(name = "first_name", nullable = false, length = 100)
        String firstName,


        @Column(name = "middle_name", length = 100)
        String middleName,

        @Column(name = "last_name", nullable = false, length = 100)
        String lastName
) {


    public Name {

        if (firstName == null) {
            throw new InvalidNameException("first name cannot be null");
        }

        if (lastName == null) {
            throw new InvalidNameException("last name cannot be null");
        }


        firstName = firstName.trim();
        lastName = lastName.trim();
        middleName = (middleName == null) ? null : middleName.trim();


        if (firstName.isEmpty()) {
            throw new InvalidNameException("first name cannot be empty");
        }
        if (lastName.isEmpty()) {
            throw new InvalidNameException("last name cannot be empty");
        }


        if (firstName.indexOf(' ') >= 0) {
            throw new InvalidNameException("first name cannot contain spaces");
        }
        if (lastName.indexOf(' ') >= 0) {
            throw new InvalidNameException("last name cannot contain spaces");
        }
        if (middleName != null && middleName.isEmpty()) {

            throw new InvalidNameException("middle name cannot be empty; pass null instead");
        }
        if (middleName != null && middleName.indexOf(' ') >= 0) {
            throw new InvalidNameException("middle name cannot contain spaces");
        }


        firstName = titleCase(firstName);
        lastName = titleCase(lastName);
        if (middleName != null) {
            middleName = titleCase(middleName);
        }

    }


    public Name(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    private static String titleCase(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }
        String lower = input.toLowerCase(Locale.ROOT);
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }

    public String display() {
        if (middleName == null) {
            return title(firstName) + " " + title(lastName);
        }
        return title(firstName) + " " + title(middleName) + " " + title(lastName);
    }

    private static String title(String s) {
        if (s == null || s.isEmpty()) return s;
        // basit TitleCase
        return s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1);
    }


}
