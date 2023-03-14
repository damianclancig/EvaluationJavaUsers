package com.evaluation.users.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    // digit + lowercase char + uppercase char + punctuation + symbol
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
