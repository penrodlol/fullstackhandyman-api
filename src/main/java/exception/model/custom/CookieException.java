package exception.model.custom;

public class CookieException extends Exception {
    private static final long serialVersionUID = 1L;

    public CookieException(String message) {
        super(message);
    }
}