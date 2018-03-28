package main.exceptions;

public class InvalidInputException extends RuntimeException {
    private static String INVALID_INPUT = "Invalid input, Please try it again";

    public InvalidInputException() {
        super(INVALID_INPUT);
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
