package uco.edu.uco.ucoparking.crosscutting.validation.rule.string;

import co.edu.uco.ucoparking.crosscutting.validation.rule.Rule;

public final class MaxLengthStringRule implements Rule<String> {

    private final int maxLength;
    private final String userMessage;
    private final String technicalMessage;

    public MaxLengthStringRule(int maxLength, String userMessage, String technicalMessage) {
        this.maxLength = maxLength;
        this.userMessage = userMessage;
        this.technicalMessage = technicalMessage;
    }

    @Override
    public boolean isSatisfiedBy(String value) {
        return value != null && value.length() <= maxLength;
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
