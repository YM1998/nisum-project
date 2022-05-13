package co.com.nisum.domain.usecase.common;

import co.com.nisum.domain.model.enums.Patterns;

import java.util.regex.Pattern;

public class ValidatePattern {

    public static Boolean validate(String value, String pattern) {
        Pattern patternExp = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        return patternExp.matcher(value).matches();
    }
}
