package co.edu.uco.ucoparking.crosscutting.validation.cleaner;

public interface Cleaner<T> {

    T clean(T value);
}