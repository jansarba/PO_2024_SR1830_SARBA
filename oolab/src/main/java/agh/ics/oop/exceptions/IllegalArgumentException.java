package agh.ics.oop.exceptions;

public class IllegalArgumentException extends RuntimeException {
    private final int errorCode;

    public IllegalArgumentException(String message) {
        super(message);
        this.errorCode = 0;
    }

    public IllegalArgumentException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "IllegalArgumentException{errorCode=" + errorCode + ", message=" + getMessage() + "}";
    }
}