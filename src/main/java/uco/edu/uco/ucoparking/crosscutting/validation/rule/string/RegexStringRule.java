package uco.edu.uco.ucoparking.crosscutting.validation.rule.string;

import co.edu.uco.ucoparking.crosscutting.validation.rule.Rule;

public final class RegexStringRule implements Rule<String> {

    private final String pattern;
    private final String userMessage;
    private final String technicalMessage;

    public RegexStringRule(String pattern, String userMessage, String technicalMessage) {
        this.pattern = pattern;
        this.userMessage = userMessage;
        this.technicalMessage = technicalMessage;
    }

    @Override
    public boolean isSatisfiedBy(String value) {
        return value != null && value.matches(pattern);
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
