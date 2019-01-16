package net.roundya.restlayer.errorhandling;

public class UserNotAuthorizedException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public UserNotAuthorizedException() {
		super();
	}

	public UserNotAuthorizedException(final String message) {
		super(message);
	}

}