package project_ifrill.exception;

@SuppressWarnings("serial")
public class DuplicateException extends RuntimeException {

    public DuplicateException(String message) {
        super(message);
    }

}
