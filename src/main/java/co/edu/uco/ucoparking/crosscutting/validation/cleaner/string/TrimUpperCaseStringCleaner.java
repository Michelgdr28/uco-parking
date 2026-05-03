package co.edu.uco.ucoparking.crosscutting.validation.cleaner.string;

import co.edu.uco.ucoparking.crosscutting.validation.cleaner.Cleaner;

public final class TrimUpperCaseStringCleaner implements Cleaner<String> {

    @Override
    public String clean(String value) {
        return (value == null) ? null : value.trim().toUpperCase();
    }
}
