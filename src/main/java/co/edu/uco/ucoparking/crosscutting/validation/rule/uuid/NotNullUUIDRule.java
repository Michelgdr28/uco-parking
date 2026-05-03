package co.edu.uco.ucoparking.crosscutting.validation.rule.uuid;

import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.validation.rule.Rule;

public final class NotNullUUIDRule implements Rule<UUID> {

    private final String userMessage;
    private final String technicalMessage;

    public NotNullUUIDRule(String userMessage, String technicalMessage) {
        this.userMessage = userMessage;
        this.technicalMessage = technicalMessage;
    }

    @Override
    public boolean isSatisfiedBy(UUID value) {
        return value != null;
    }

    @Override
    public String getUserMessage() {
        return userMessage;
    }

    @Override
    public String getTechnicalMessage() {
        return technicalMessage;
    }
}
