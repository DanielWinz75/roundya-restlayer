package net.roundya.restlayer.errorhandling;

public class UserExistsException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public UserExistsException() {
		super();
	}

	public UserExistsException(final String message) {
		super(message);
	}

}