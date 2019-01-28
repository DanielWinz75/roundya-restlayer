package net.roundya.restlayer.errorhandling;

public class TokenExpiredException extends RuntimeException {

    private static final long serialVersionUID = -9079454849611061074L;

    public TokenExpiredException() {
        super();
    }

    public TokenExpiredException(final String message) {
        super(message);
    }

}