package co.edu.uco.ucoparking.crosscutting.helper;

import java.util.UUID;

public final class UUIDHelper {

    private static final UUID EMPTY = new UUID(0L, 0L);

    private UUIDHelper() {
    }

    public static boolean isNull(UUID value) {
        return value == null;
    }

    public static UUID clean(UUID value) {
        if (isNull(value)) {
            return EMPTY;
        }
        return value;
    }
}