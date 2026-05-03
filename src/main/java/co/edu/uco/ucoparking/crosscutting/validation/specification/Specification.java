package co.edu.uco.ucoparking.crosscutting.validation.specification;

import java.util.List;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.validation.rule.Rule;

public final class Specification<T> {

    private final List<Rule<T>> rules;

    @SafeVarargs
    public Specification(Rule<T>... rules) {
        this.rules = List.of(rules);
    }

    public void validate(T value) {
        for (Rule<T> rule : rules) {
            if (!rule.isSatisfiedBy(value)) {
                throw UcoParkingException.create(rule.getUserMessage(), rule.getTechnicalMessage());
            }
        }
    }
}
