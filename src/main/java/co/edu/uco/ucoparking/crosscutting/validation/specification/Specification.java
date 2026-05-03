package co.edu.uco.ucoparking.crosscutting.validation.specification;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.validation.rule.Rule;

public final class Specification<T> {

    private List<Rule<T>> rules = new ArrayList<>();

    public void addRule(Rule<T> rule) {
        rules.add(rule);
    }

    public void validate(T value) {
        for (Rule<T> rule : rules) {
            if (!rule.isSatisfiedBy(value)) {
                throw UcoParkingException.create(rule.getUserMessage(), rule.getTechnicalMessage());
            }
        }
    }
}
