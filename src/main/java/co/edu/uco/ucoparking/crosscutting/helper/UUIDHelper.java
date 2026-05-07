package co.edu.uco.ucoparking.crosscutting.helper;

import java.util.UUID;

public final class UUIDHelper {

    private UUIDHelper() {
    }

    public static boolean isNull(UUID value) {
        return value == null;
    }
}
