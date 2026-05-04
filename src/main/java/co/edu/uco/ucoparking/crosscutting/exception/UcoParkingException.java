package co.edu.uco.ucoparking.crosscutting.exception;

public final class UcoParkingException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String userMessage;

    private UcoParkingException(String userMessage, String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static UcoParkingException create(String userMessage, String technicalMessage) {
        return new UcoParkingException(userMessage, technicalMessage);
    }

    public String getUserMessage() {
        return userMessage;
    }
}