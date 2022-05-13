package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidate {
    private static final String DATE_REGEX = "\\d{4}[-|]\\d{2}[-|]\\d{2}";
    private static Pattern pattern;

    public DateValidate() {
        pattern = Pattern.compile(DATE_REGEX);
    }

    public boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
