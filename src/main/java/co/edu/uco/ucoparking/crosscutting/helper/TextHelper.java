package co.edu.uco.ucoparking.crosscutting.helper;

public final class TextHelper {

    private TextHelper() {
    }

    public static boolean isNull(String value) {
        return value == null;
    }

    public static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public static boolean isBelowMinLength(String value, int min) {
        return value == null || value.length() < min;
    }

    public static boolean exceedsMaxLength(String value, int max) {
        return value == null || value.length() > max;
    }

    public static boolean doesNotMatchPattern(String value, String pattern) {
        return value == null || !value.matches(pattern);
    }

    public static String trimAndUpperCase(String value) {
        if (value == null) {
            return null;
        }
        return value.trim().toUpperCase();
    }
}
