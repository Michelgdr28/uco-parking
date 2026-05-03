package co.edu.uco.ucoparking.crosscutting.validation.rule;

public interface Rule<T> {

    boolean isSatisfiedBy(T value);

    String getUserMessage();

    String getTechnicalMessage();
}
