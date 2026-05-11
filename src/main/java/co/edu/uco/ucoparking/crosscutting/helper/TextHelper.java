package co.edu.uco.ucoparking.crosscutting.helper;

public final class TextHelper {

    private static final String EMPTY = "";

    private TextHelper() {
    }


    public static boolean isNull(String value) {
        return value == null;
    }

    public static boolean isBlank(String value) {
        if (isNull(value)) {
            return true;
        }
        return value.isBlank();
    }

    public static boolean isBelowMinLength(String value, int min) {
        if (isNull(value)) {
            return true;
        }
        return value.length() < min;
    }

    public static boolean exceedsMaxLength(String value, int max) {
        if (isNull(value)) {
            return true;
        }
        return value.length() > max;
    }

    public static boolean doesNotMatchPattern(String value, String pattern) {
        if (isNull(value)) {
            return true;
        }
        return !value.matches(pattern);
    }


    public static String clean(String value) {
        if (isNull(value)) {
            return EMPTY;
        }
        return value.trim();
    }

    public static String cleanAndUpperCase(String value) {
        if (isNull(value)) {
            return EMPTY;
        }
        return value.trim().toUpperCase();
    }

    public static String cleanAndLowerCase(String value) {
        if (isNull(value)) {
            return EMPTY;
        }
        return value.trim().toLowerCase();
    }
}